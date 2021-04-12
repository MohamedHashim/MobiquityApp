package com.mohamedhashim.mobiquityapp.data.remote.service

import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

interface CategoriesService {

    @GET("/")
    fun fetchCategories(): Call<List<Category>>
}
