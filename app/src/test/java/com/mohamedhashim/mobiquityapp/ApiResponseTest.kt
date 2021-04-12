package com.mohamedhashim.mobiquityapp

import com.mohamedhashim.mobiquityapp.data.remote.ApiResponse
import okhttp3.ResponseBody
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse.error<String>(exception)
        MatcherAssert.assertThat(apiResponse.message, CoreMatchers.`is`("foo"))
    }

    @Test
    fun success() {
        val apiResponse = ApiResponse.of { Response.success("foo") }
        if (apiResponse is ApiResponse.Success) {
            MatcherAssert.assertThat(apiResponse.data, CoreMatchers.`is`("foo"))
        }
    }
}
