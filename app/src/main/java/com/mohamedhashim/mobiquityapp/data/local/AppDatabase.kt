package com.mohamedhashim.mobiquityapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohamedhashim.mobiquityapp.data.entities.converters.ProductsConverter
import com.mohamedhashim.mobiquityapp.data.entities.converters.SalePriceConverter
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product
import com.mohamedhashim.mobiquityapp.data.local.dao.CategoriesDao

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@Database(
    entities = [Category::class, Product::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(value = [ProductsConverter::class, SalePriceConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoriesDao
}
