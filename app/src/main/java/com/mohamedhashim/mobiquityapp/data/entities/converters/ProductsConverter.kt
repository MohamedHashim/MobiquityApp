package com.mohamedhashim.mobiquityapp.data.entities.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class ProductsConverter {
    @TypeConverter
    fun fromString(value: String): List<Product>? {
        val listType = object : TypeToken<List<Product>>() {}.type
        return Gson().fromJson<List<Product>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Product>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
