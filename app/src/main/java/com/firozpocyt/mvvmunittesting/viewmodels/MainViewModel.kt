package com.firozpocyt.mvvmunittesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firozpocyt.mvvmunittesting.Utils.NetworkResult
import com.firozpocyt.mvvmunittesting.models.ProductListItem
import com.firozpocyt.mvvmunittesting.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<NetworkResult<List<ProductListItem>>>()
    val products : LiveData<NetworkResult<List<ProductListItem>>>
        get() = _products

    fun getProducts(){
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.postValue(result)
        }
    }

}