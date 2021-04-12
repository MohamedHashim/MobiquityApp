package com.mohamedhashim.mobiquityapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mohamedhashim.mobiquityapp.ApiUtil.getCall
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.local.dao.CategoriesDao
import com.mohamedhashim.mobiquityapp.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquityapp.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquityapp.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquityapp.ui.component.categories.CategoriesViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesViewModelTest {

    private lateinit var viewModel: CategoriesViewModel

    private lateinit var categoriesRepository: CategoriesRepository
    private val categoriesService = mock<CategoriesService>()
    private val categoriesClient = CategoriesClient(categoriesService)
    private val categoriesDao = mock<CategoriesDao>()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        this.categoriesRepository = CategoriesRepository(categoriesClient, categoriesDao)
        this.viewModel = CategoriesViewModel(categoriesRepository)
    }

    @Test
    fun loadCategoriesFromNetwork() = runBlocking {
        val mockResponse = MockTestUtils.mockCategoriesList()
        whenever(categoriesService.fetchCategories()).thenReturn(getCall(mockResponse))

        val data = categoriesRepository.loadCategories {}
        val observer = mock<Observer<List<Category>>>()
        data.observeForever(observer)

        verify(categoriesService, atLeastOnce()).fetchCategories()
        data.removeObserver(observer)
    }
}