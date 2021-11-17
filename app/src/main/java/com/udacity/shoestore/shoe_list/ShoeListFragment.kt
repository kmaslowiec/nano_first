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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.shoe_detail.ShoeViewModel


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

    override fun onStart() {
        super.onStart()
        for (i in 1..20){
            createTextView("one")
            createTextView("two")
        }
    }

    private fun createTextView(text: String) {
        val padding = resources.getDimension(R.dimen.padding)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        val textView = TextView(this.context)

        params.setMargins(8)
        textView.text = text
        textView.layoutParams = params
        textView.textSize = resources.getDimension(R.dimen.text_size)
        textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.textview_background))
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
        binding.rootLayout.addView(textView)
    }
}