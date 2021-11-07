package com.udacity.shoestore.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.shoe_detail.ShoeViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private var shoe: String = ""
    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding : FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)

        binding.shoeViewModel = viewModel

        binding.lifecycleOwner = requireActivity()

        viewModel.getShoe.observe(viewLifecycleOwner, { shoe = it.name })



        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(
                ShoeListFragmentDirections
                    .actionShoeListFragmentToShoeDetailFragment()
            )
        }

        return binding.root
    }

/*    override fun onResume() {
        super.onResume()
        binding.firstShoe.text = shoe
    }*/
}