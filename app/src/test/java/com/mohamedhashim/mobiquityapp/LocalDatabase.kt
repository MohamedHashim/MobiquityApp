package com.mohamedhashim.mobiquityapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.mohamedhashim.mobiquityapp.data.local.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class LocalDatabase {

    lateinit var db: AppDatabase

    @Before
    fun initDB() {
        this.db =
            Room.inMemoryDatabaseBuilder(
                getApplicationContext(),
                AppDatabase::class.java
            )
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun closeDB() {
        this.db.close()
    }
}
