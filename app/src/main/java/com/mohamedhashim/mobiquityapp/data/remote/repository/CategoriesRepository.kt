package com.mohamedhashim.mobiquityapp.data.remote.repository

import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.local.dao.CategoriesDao
import com.mohamedhashim.mobiquityapp.data.remote.ApiResponse
import com.mohamedhashim.mobiquityapp.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquityapp.data.remote.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

class CategoriesRepository constructor(
    private val categoriesClient: CategoriesClient,
    private val categoriesDao: CategoriesDao
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
                            categoriesDao.insertCategories(categories)
                            liveData.postValue(categories)
                        }
                    }
                    is ApiResponse.Failure.Error -> {
                        error(response.message())
                        categories = getLocalCategories()
                        liveData.postValue(categories)
                    }
                    is ApiResponse.Failure.Exception -> {
                        error(response.message())
                        categories = getLocalCategories()
                        liveData.postValue(categories)
                    }
                }
            }
            liveData.apply { postValue(categories) }
        }

    private fun getLocalCategories() = categoriesDao.getCategories()
}