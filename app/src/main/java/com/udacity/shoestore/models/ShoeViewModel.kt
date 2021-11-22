package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    /*private var _getShoe = MutableLiveData<Shoe>()
    val getShoe : LiveData<Shoe> get() = _getShoe*/

    private var shoes: MutableList<Shoe> = mutableListOf()
    private val _getShoes = MutableLiveData<MutableList<Shoe>>()
    val getShoes: LiveData<MutableList<Shoe>> get() = _getShoes


    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        _getShoes.value = shoes
    }
}