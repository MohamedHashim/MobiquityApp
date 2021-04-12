package com.mohamedhashim.mobiquityapp.ui.base.bindings

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mohamedhashim.mobiquityapp.BASE_URL
import com.mohamedhashim.mobiquityapp.R

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

@BindingAdapter("productImage")
fun ImageView.bindProductImage(imagePath: String) {
    Glide.with(this.context)
        .load(BASE_URL + imagePath)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_not_found))
        .into(this)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("productAmount", "productCurrency")
fun TextView.bindProductPriceTxt(amount: String, currency: String) {
    this.text = "${resources.getString(R.string.price)} $amount $currency"
}
