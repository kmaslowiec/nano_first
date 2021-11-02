package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.welcome.WelcomeFragment

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentLoginBinding.inflate(inflater)

        binding.login.setOnClickListener{ view -> view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcomeFragment()) }
        binding.newLogin.setOnClickListener{view -> view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcomeFragment())}

        // Inflate the layout for this fragment
        return binding.root
    }
}