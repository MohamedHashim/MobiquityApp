package com.mohamedhashim.mobiquity_private.ui.component.categories

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.mohamedhashim.mobiquity_private.data.entities.dto.Category
import com.mohamedhashim.mobiquity_private.data.entities.dto.Product
import com.mohamedhashim.mobiquity_private.data.remote.repository.CategoriesRepository
import com.mohamedhashim.mobiquity_private.ui.base.LiveCoroutinesViewModel

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesViewModel constructor(private val categoriesRepository: CategoriesRepository) : LiveCoroutinesViewModel() {

}