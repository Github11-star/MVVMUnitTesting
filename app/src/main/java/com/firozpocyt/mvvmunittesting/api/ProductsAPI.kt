package com.firozpocyt.mvvmunittesting.api

import com.firozpocyt.mvvmunittesting.models.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductListItem>>
}