package com.mohamedhashim.mobiquity_private.ui.component.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.mobiquity_private.ui.base.bindings.DataBindingFragment
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.databinding.FragmentProductDetailsBinding

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class ProductDetailsFragment : DataBindingFragment() {

    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_product_details, container
        )
        return binding.root
    }
}