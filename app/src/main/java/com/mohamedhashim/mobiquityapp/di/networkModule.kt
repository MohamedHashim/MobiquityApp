package com.mohamedhashim.mobiquityapp.di

import com.mohamedhashim.mobiquityapp.data.remote.RequestInterceptor
import com.mohamedhashim.mobiquityapp.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquityapp.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquityapp.BASE_URL
import com.mohamedhashim.mobiquityapp.timeoutConnect
import com.mohamedhashim.mobiquityapp.timeoutRead
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(CategoriesService::class.java) }

    single { CategoriesClient(get()) }
}