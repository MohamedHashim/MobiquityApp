package com.mohamedhashim.mobiquity_private.data.entities.dto

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
@Parcelize
class SalePrice(
    var amount: String,
    var currency: String,
) : Parcelable