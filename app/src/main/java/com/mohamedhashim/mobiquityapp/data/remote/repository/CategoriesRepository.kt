package com.mohamedhashim.mobiquity_private.data.remote.repository

import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.mobiquity_private.data.entities.dto.Category
import com.mohamedhashim.mobiquity_private.data.remote.ApiResponse
import com.mohamedhashim.mobiquity_private.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquityapp.data.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

class CategoriesRepository constructor(
    private val categoriesClient: CategoriesClient
) {

    suspend fun loadCategories(error: (String) -> Unit) =
        withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<Category>>()
            var categories = emptyList<Category>()
            categoriesClient.fetchCategoriesList { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            categories = data
                            liveData.postValue(categories)
                        }
                    }
                    is ApiResponse.Failure.Error -> {
                        error(response.message())
                        liveData.postValue(categories)
                    }
                    is ApiResponse.Failure.Exception -> {
                        error(response.message())
                        liveData.postValue(categories)
                    }
                }
            }
            liveData.apply { postValue(categories) }
        }
}