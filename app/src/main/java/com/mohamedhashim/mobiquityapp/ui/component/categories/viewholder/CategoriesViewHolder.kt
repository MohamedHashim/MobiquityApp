package com.mohamedhashim.mobiquityapp.ui.component.categories.viewholder

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.ui.base.bindings.inflate
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.databinding.ItemCategoryBinding
import smartadapter.viewholder.SmartViewHolder

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesViewHolder(parentView: ViewGroup) : SmartViewHolder<Category>(
    parentView.inflate<ItemCategoryBinding>(R.layout.item_category).root
) {
    override fun bind(item: Category) {
        val binding = DataBindingUtil.getBinding<ItemCategoryBinding>(itemView)
        binding?.category = item
    }
}