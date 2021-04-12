package com.mohamedhashim.mobiquityapp.data.entities.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mohamedhashim.mobiquityapp.data.entities.dto.SalePrice

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class SalePriceConverter {
    @TypeConverter
    fun fromString(value: String): SalePrice? {
        val type = object : TypeToken<SalePrice>() {}.type
        return Gson().fromJson<SalePrice>(value, type)
    }

    @TypeConverter
    fun fromList(salePrice: SalePrice?): String {
        val gson = Gson()
        return gson.toJson(salePrice)
    }
}
