package com.mohamedhashim.mobiquityapp.ui.base.bindings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */

fun <M : ViewDataBinding> ViewGroup.inflate(@LayoutRes layoutRes: Int): M {
    return DataBindingUtil.inflate(
        LayoutInflater.from(context),
        layoutRes,
        this,
        false
    )
}