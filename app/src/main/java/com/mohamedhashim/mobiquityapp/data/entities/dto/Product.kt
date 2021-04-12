package com.mohamedhashim.mobiquityapp.data.entities.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@Entity
@Parcelize
class Product(
    @PrimaryKey var id: String,
    var name: String,
    var url: String,
    var description: String,
    var salePrice: SalePrice,
) : Parcelable