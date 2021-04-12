package com.mohamedhashim.mobiquity.di

import com.mohamedhashim.mobiquity.ui.component.categories.CategoriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
val viewModelModule = module {
    viewModel { CategoriesViewModel(get()) }
}