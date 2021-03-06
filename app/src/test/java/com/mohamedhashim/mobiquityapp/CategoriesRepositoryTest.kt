package com.mohamedhashim.mobiquityapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mohamedhashim.mobiquityapp.ApiUtil.getCall
import com.mohamedhashim.mobiquityapp.MockTestUtils.Companion.mockCategoriesList
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.local.dao.CategoriesDao
import com.mohamedhashim.mobiquityapp.data.remote.ApiResponse
import com.mohamedhashim.mobiquityapp.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquityapp.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquityapp.data.remote.service.CategoriesService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesRepositoryTest {

    private lateinit var repository: CategoriesRepository
    private lateinit var client: CategoriesClient
    private val service = mock<CategoriesService>()
    private val categoriesDao = mock<CategoriesDao>()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        client = CategoriesClient(service)
        repository = CategoriesRepository(client, categoriesDao)
    }

    @Test
    fun loadCategoriesFromNetworkTest() = runBlocking {
        val mockResponse = mockCategoriesList()
        whenever(service.fetchCategories()).thenReturn(getCall(mockResponse))

        val data = repository.loadCategories {}

        val observer = mock<Observer<List<Category>>>()
        data.observeForever(observer)
        val updatedData = mockCategoriesList()
        whenever(categoriesDao.getCategories()).thenReturn(updatedData)

        data.postValue(updatedData)
        verify(observer).onChanged(updatedData)

        client.fetchCategoriesList {
            when (it) {
                is ApiResponse.Success -> {
                    assertEquals(it.data, `is`(mockResponse))
                }
                else -> MatcherAssert.assertThat(it, CoreMatchers.instanceOf(ApiResponse.Failure::class.java))
            }
        }
    }
}
