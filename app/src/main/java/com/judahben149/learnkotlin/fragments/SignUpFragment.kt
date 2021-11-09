package com.judahben149.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.FragmentSignInBinding
import com.judahben149.learnkotlin.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {


    private var fragmentSignUpBinding: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentSignUpBinding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        return fragmentSignUpBinding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignUpBinding?.btnLogInSignInPage?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_authenticatedFragment2)
        }

        fragmentSignUpBinding?.tvSignInSignUpScreen?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_signInFragment)
        }

    }


}