package com.mohamedhashim.mobiquityapp.data.remote

import com.mohamedhashim.mobiquityapp.contentType
import com.mohamedhashim.mobiquityapp.contentTypeValue
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val request = originalRequest.newBuilder()
            .header(contentType, contentTypeValue)
            .method(originalRequest.method, originalRequest.body)
            .build()

        return chain.proceed(request)
    }
}