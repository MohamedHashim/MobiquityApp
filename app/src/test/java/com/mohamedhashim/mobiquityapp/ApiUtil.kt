package com.mohamedhashim.mobiquity

import com.mohamedhashim.mobiquity.data.entities.dto.Category
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
object ApiUtil {

    fun <T> getCall(data: T): Call<T> = object : Call<T> {
        override fun enqueue(callback: Callback<T>) = Unit
        override fun isExecuted() = false
        override fun clone(): Call<T> = this
        override fun isCanceled() = false
        override fun cancel() = Unit
        override fun request(): Request = Request.Builder().build()
        override fun execute(): Response<T> = Response.success(data)
        override fun timeout(): Timeout = Timeout()
    }
}
