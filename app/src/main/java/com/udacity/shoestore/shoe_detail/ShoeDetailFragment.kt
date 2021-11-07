package com.udacity.shoestore.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(layoutInflater, R.layout.fragment_shoe_detail, container, false)

        binding.buttonCancel.setOnClickListener { view ->
            view.findNavController().navigate(
                ShoeDetailFragmentDirections
                    .actionShoeDetailFragmentToShoeListFragment()
            )
        }

        val model: ShoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.buttonSave.setOnClickListener { view ->
            val name = binding.nameEdit.text.toString()
            val size = if(binding.sizeEdit.text.toString().isNotEmpty()) binding.sizeEdit.text.toString().toDouble() else 0.0
            val company = binding.companyEdit.text.toString()
            val desc = binding.descEdit.text.toString()

            val newShoe = Shoe(name, size, company, desc)
            model.addShoe(newShoe)
            view.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
}