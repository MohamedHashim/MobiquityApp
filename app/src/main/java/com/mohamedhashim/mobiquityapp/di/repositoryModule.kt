package com.mohamedhashim.mobiquityapp.di

import com.mohamedhashim.mobiquityapp.data.remote.repository.CategoriesRepository
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
val repositoryModule = module {
    single { CategoriesRepository(get(), get()) }
}