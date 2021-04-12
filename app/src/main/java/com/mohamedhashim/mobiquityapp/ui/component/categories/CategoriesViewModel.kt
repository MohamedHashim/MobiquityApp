package com.mohamedhashim.mobiquity.ui.component.categories

import com.mohamedhashim.mobiquity.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquityapp.ui.base.LiveCoroutinesViewModel

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesViewModel constructor(private val categoriesRepository: CategoriesRepository) : LiveCoroutinesViewModel() {

}