package com.mohamedhashim.mobiquityapp.ui.component.categories

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product
import com.mohamedhashim.mobiquityapp.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquityapp.ui.base.LiveCoroutinesViewModel

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesViewModel constructor(
    private val categoriesRepository: CategoriesRepository
) : LiveCoroutinesViewModel() {

    var categoriesLiveData: LiveData<List<Category>> = launchOnViewModelScope {
        this.categoriesRepository.loadCategories {}
    }

    companion object {
        private const val ProductKey = "Product"
        fun createArguments(product: Product): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(ProductKey, product)
            return bundle
        }
    }
}