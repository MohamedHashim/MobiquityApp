package com.mohamedhashim.mobiquity.data.entities.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@Parcelize
class Category(
    val id: String,
    val name: String,
    val description: String,
    val products: List<Product>
) : Parcelable