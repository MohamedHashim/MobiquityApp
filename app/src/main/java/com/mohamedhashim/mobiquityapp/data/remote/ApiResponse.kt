package com.mohamedhashim.mobiquityapp.data.remote

import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
sealed class ApiResponse<out T> {

    class Success<T>(response: Response<T>) : ApiResponse<T>() {
        val data: T? = response.body()
        override fun toString() = "[ApiResponse.Success]: $data"
    }

    sealed class Failure {
        class Error<out T>(response: Response<out T>) : ApiResponse<T>() {
            val responseBody: ResponseBody? = response.errorBody()?.apply { close() }
            val code: Int = response.code()
            override fun toString(): String =
                "[ApiResponse.Failure $code]: ${responseBody?.string()}"
        }

        class Exception<out T>(exception: Throwable) : ApiResponse<T>() {
            val message: String? = exception.localizedMessage
            override fun toString(): String = "[ApiResponse.Failure]: $message"
        }
    }

    companion object {

        fun <T> error(ex: Throwable) = Failure.Exception<T>(ex)
        fun <T> of(f: () -> Response<T>): ApiResponse<T> = try {
            val response = f()
            if (response.isSuccessful) {
                Success(response)
            } else {
                Failure.Error(response)
            }
        } catch (ex: Exception) {
            Failure.Exception(ex)
        }
    }
}