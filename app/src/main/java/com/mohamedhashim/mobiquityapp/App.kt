package com.mohamedhashim.mobiquityapp

import android.app.Application
import com.mohamedhashim.mobiquityapp.di.networkModule
import com.mohamedhashim.mobiquityapp.di.persistenceModule
import com.mohamedhashim.mobiquityapp.di.repositoryModule
import com.mohamedhashim.mobiquityapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(persistenceModule)
        }
    }
}