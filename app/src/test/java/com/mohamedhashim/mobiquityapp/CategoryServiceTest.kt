package com.mohamedhashim.mobiquity_private

import com.mohamedhashim.mobiquity_private.data.remote.ApiResponse
import com.mohamedhashim.mobiquity_private.data.remote.service.CategoriesService
import com.mohamedhashim.mobiquityapp.data.transform
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import java.io.IOException

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoryServiceTest : ApiAbstract<CategoriesService>() {

    private lateinit var service: CategoriesService

    @Before
    fun initService() {
        this.service = createService(CategoriesService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchCategoriesTest() {
        enqueueResponse("/mobcategories.json")
        this.service.fetchCategories().transform {
            when (it) {
                is ApiResponse.Success -> {
                    MatcherAssert.assertThat(it.data?.get(0)?.id, CoreMatchers.`is`("36802"))
                    MatcherAssert.assertThat(it.data?.get(0)?.name, CoreMatchers.`is`("Food"))
                    MatcherAssert.assertThat(it.data?.get(0)?.description, CoreMatchers.`is`(""))
                    MatcherAssert.assertThat(
                        it.data?.get(0)?.products,
                        CoreMatchers.`is`("support group")
                    )
                }
                else -> MatcherAssert.assertThat(
                    it,
                    CoreMatchers.instanceOf(ApiResponse.Failure::class.java)
                )
            }
        }
    }
}
