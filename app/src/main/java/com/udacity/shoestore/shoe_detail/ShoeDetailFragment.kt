package com.udacity.shoestore.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

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

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.shoeViewModel = viewModel

        binding.lifecycleOwner = this

        binding.shoe = Shoe("", 0.0, "", "")

        binding.buttonSave.setOnClickListener { view ->
            val shoeName = binding.shoe

            viewModel.addShoe(shoeName!!)

            view.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
}