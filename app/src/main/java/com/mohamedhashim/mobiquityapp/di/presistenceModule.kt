package com.mohamedhashim.mobiquityapp.di

import androidx.room.Room
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().categoryDao() }
}