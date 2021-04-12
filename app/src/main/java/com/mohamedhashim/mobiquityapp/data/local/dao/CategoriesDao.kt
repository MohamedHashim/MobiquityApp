package com.mohamedhashim.mobiquityapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<Category>)

    @Query("SELECT * FROM Category")
    fun getCategories(): List<Category>

}