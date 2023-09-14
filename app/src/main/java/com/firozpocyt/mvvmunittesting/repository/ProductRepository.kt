package com.firozpocyt.mvvmunittesting.repository

import com.firozpocyt.mvvmunittesting.Utils.NetworkResult
import com.firozpocyt.mvvmunittesting.api.ProductsAPI
import com.firozpocyt.mvvmunittesting.models.ProductListItem

class ProductRepository(private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if(response.isSuccessful){
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}