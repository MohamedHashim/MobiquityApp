package com.mohamedhashim.mobiquity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mohamedhashim.mobiquity.ApiUtil.getCall
import com.mohamedhashim.mobiquity.data.entities.dto.Category
import com.mohamedhashim.mobiquity.data.remote.client.CategoriesClient
import com.mohamedhashim.mobiquity.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquity.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquity.ui.component.categories.CategoriesViewModel
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

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        this.categoriesRepository = CategoriesRepository(categoriesClient)
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