package com.mohamedhashim.mobiquity_private.ui.component.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.mobiquity_private.ui.base.bindings.DataBindingFragment
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.databinding.FragmentCategoriesListBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesFragment : DataBindingFragment() {

    private val viewModel: CategoriesViewModel by viewModel()
    private lateinit var binding: FragmentCategoriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_categories_list, container
        )
        return binding.root
    }

}