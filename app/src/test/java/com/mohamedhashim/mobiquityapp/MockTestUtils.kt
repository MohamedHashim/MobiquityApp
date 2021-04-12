package com.mohamedhashim.mobiquity

import com.mohamedhashim.mobiquity.data.entities.dto.Category
import com.mohamedhashim.mobiquity.data.entities.dto.Product
import com.mohamedhashim.mobiquity.data.entities.dto.SalePrice

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class MockTestUtils {
    companion object {

        fun mockCategory() = Category(

            "1", "Food", "Some info for food products", mockProductsList()
        )

        fun mockProduct() = Product("3", "Milk", "/Milk.jpg", "white milk", mockSalePrice())

        fun mockSalePrice() = SalePrice("30", "EUR")

        fun mockCategoriesList(): List<Category> {
            val categories = ArrayList<Category>()
            categories.add(mockCategory())
            categories.add(mockCategory())
            categories.add(mockCategory())
            return categories
        }

        fun mockProductsList(): List<Product> {
            val products = ArrayList<Product>()
            products.add(mockProduct())
            products.add(mockProduct())
            products.add(mockProduct())
            return products
        }
    }
}