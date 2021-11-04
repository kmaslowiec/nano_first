package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.welcome.WelcomeFragment

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(layoutInflater, R.layout.fragment_login, container,false)



        binding.buttonLogin.setOnClickListener{ view -> view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcomeFragment()) }
        binding.buttonNewLogin.setOnClickListener{view -> view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcomeFragment())}

        // Inflate the layout for this fragment
        return binding.root
    }
}