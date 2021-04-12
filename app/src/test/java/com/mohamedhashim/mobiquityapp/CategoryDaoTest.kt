package com.mohamedhashim.mobiquityapp

import com.mohamedhashim.mobiquityapp.MockTestUtils.Companion.mockCategoriesList
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class CategoryDaoTest : LocalDatabase() {

    @Test
    fun insertAndReadTest() {
        val mockData = mockCategoriesList()
        db.categoryDao().insertCategories(mockData)
        val loadFromDB = db.categoryDao().getCategories()[0]
        MatcherAssert.assertThat(loadFromDB.id, `is`("1"))
    }
}
