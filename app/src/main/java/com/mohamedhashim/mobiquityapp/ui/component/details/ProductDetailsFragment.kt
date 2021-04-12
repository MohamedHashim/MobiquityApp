package com.mohamedhashim.mobiquityapp.ui.component.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product
import com.mohamedhashim.mobiquityapp.ui.base.bindings.DataBindingFragment
import com.mohamedhashim.mobiquityapp.databinding.FragmentProductDetailsBinding
import kotlinx.android.synthetic.main.fragment_product_details.*

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
        return binding.apply {
            product = (requireArguments().get(getString(R.string.product_key))) as Product
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, activity as AppCompatActivity)
    }

    private fun initToolbar(toolbar: Toolbar, activity: AppCompatActivity) {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = ""
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}