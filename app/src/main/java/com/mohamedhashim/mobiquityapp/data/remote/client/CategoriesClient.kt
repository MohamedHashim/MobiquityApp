package com.mohamedhashim.mobiquity.data.remote.client

import com.mohamedhashim.mobiquity.data.entities.dto.Category
import com.mohamedhashim.mobiquity.data.remote.ApiResponse
import com.mohamedhashim.mobiquity.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquityapp.data.transform

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

class CategoriesClient(private val service: CategoriesService) {

    fun fetchCategoriesList(onResult: (response: ApiResponse<List<Category>>) -> Unit) {
        this.service.fetchCategories().transform(onResult)
    }
}