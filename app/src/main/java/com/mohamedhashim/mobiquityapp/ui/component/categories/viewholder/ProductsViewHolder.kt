package com.mohamedhashim.mobiquityapp.ui.component.categories.viewholder

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product
import com.mohamedhashim.mobiquityapp.databinding.ItemProductBinding
import com.mohamedhashim.mobiquityapp.ui.base.bindings.inflate
import com.mohamedhashim.mobiquityapp.ui.component.categories.CategoriesViewModel
import smartadapter.viewholder.SmartViewHolder

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class ProductsViewHolder(parentView: ViewGroup) : SmartViewHolder<Product>(
    parentView.inflate<ItemProductBinding>(R.layout.item_product).root
) {
    override fun bind(item: Product) {
        val binding = DataBindingUtil.getBinding<ItemProductBinding>(itemView)
        binding?.product = item
        itemView.setOnClickListener {
            navigateToProductDetails(item)
        }
    }

    private fun navigateToProductDetails(item: Product) {
        findNavController(itemView).navigate(
            R.id.actionProductDetails,
            CategoriesViewModel.createArguments(item)
        )
    }
}