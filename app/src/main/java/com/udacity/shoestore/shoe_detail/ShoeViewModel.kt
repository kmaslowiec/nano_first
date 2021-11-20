package com.udacity.shoestore.shoe_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private var shoes: MutableList<Shoe> = mutableListOf()
    private val _getShoes = MutableLiveData<MutableList<Shoe>>()
    val getShoes: LiveData<MutableList<Shoe>> get() = _getShoes

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        _getShoes.value = shoes
    }
}