package com.udacity.shoestore.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoe_detail.ShoeViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding : FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        viewModel.getShoe.observe(viewLifecycleOwner, {
            createTextView(it)
        })

        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(
                ShoeListFragmentDirections
                    .actionShoeListFragmentToShoeDetailFragment()
            )
        }

        return binding.root
    }

    private fun createTextView(shoe : Shoe) {
        val padding = resources.getDimension(R.dimen.padding)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        val textView = TextView(this.context)

        params.setMargins(8)

        val content = "Shoe Name: ${shoe.name}\n" +
                "Company: ${shoe.company}\n" +
                "Shoe Size: ${shoe.size}\n" +
                "Description: ${shoe.description}"

        textView.text = content
        textView.layoutParams = params
        textView.textSize = resources.getDimension(R.dimen.shoe_item_text_size)
        textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.textview_background))
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
        binding.rootLayout.addView(textView)
    }
}