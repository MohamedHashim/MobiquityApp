package com.mohamedhashim.mobiquityapp.data.remote.client

import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.remote.ApiResponse
import com.mohamedhashim.mobiquityapp.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquityapp.data.remote.transform

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

class CategoriesClient(private val service: CategoriesService) {

    fun fetchCategoriesList(onResult: (response: ApiResponse<List<Category>>) -> Unit) {
        this.service.fetchCategories().transform(onResult)
    }
}