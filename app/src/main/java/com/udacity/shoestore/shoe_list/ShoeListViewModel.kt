package com.udacity.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _getShoes = MutableLiveData<List<Shoe>>()
    val getShoes : LiveData<List<Shoe>> get() = _getShoes
}