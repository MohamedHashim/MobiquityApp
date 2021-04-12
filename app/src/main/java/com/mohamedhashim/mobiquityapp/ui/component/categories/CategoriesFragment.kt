package com.mohamedhashim.mobiquityapp.ui.component.categories

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import com.mohamedhashim.mobiquityapp.R
import com.mohamedhashim.mobiquityapp.data.entities.dto.Category
import com.mohamedhashim.mobiquityapp.data.entities.dto.Product
import com.mohamedhashim.mobiquityapp.databinding.FragmentCategoriesListBinding
import com.mohamedhashim.mobiquityapp.ui.base.bindings.DataBindingFragment
import com.mohamedhashim.mobiquityapp.ui.component.categories.viewholder.CategoriesViewHolder
import com.mohamedhashim.mobiquityapp.ui.component.categories.viewholder.ProductsViewHolder
import kotlinx.android.synthetic.main.fragment_categories_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import smartadapter.SmartRecyclerAdapter
import smartadapter.stickyheader.StickyHeaderItemDecorationExtension

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class CategoriesFragment : DataBindingFragment() {

    private val viewModel: CategoriesViewModel by viewModel()
    private lateinit var binding: FragmentCategoriesListBinding

    private lateinit var adapter: SmartRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_categories_list, container
        )
        return binding.apply {
            lifecycleOwner = this@CategoriesFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SmartRecyclerAdapter.empty()
            .map(Category::class, CategoriesViewHolder::class)
            .map(Product::class, ProductsViewHolder::class)
            .add(
                StickyHeaderItemDecorationExtension(
                    headerItemType = Category::class
                )
            )
            .into(rvCategories)
        showCategories()
    }

    private fun showCategories() {
        viewModel.categoriesLiveData.observe(viewLifecycleOwner, {
            val mArray = arrayListOf<Any>()
            var mOldContinent = ""
            for (category in it) {
                if (mOldContinent != category.id) {
                    mArray.add(
                        Category(
                            category.id,
                            category.name,
                            category.description,
                            category.products
                        )
                    )
                    mOldContinent = category.id
                }
                for (product in category.products)
                    mArray.add(
                        Product(
                            product.id,
                            product.name,
                            product.url,
                            product.description,
                            product.salePrice
                        )
                    )
            }
            adapter.addItems(mArray.toMutableList())
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}