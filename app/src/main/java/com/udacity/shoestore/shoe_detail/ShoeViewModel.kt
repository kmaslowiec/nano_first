package com.udacity.shoestore.shoe_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _getShoe = MutableLiveData<Shoe>()
    val getShoe : LiveData<Shoe> get() = _getShoe

    private val _getShoes = MutableLiveData<MutableList<Shoe>>()
    val getShoes : LiveData<MutableList<Shoe>> get() = _getShoes

    fun addShoe(shoe : Shoe){
        _getShoe.value = shoe
    //_getShoes.value?.add(shoe)
    }
}