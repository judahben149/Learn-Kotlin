package com.judahben149.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private var fragmentSignInBinding: FragmentSignInBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentSignInBinding = FragmentSignInBinding.inflate(layoutInflater,container, false)

        return fragmentSignInBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignInBinding?.btnLogInSignInPage?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_authenticatedFragment2)
        }

        fragmentSignInBinding?.btnContinueWithGoogleSignInScreen?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_authenticatedFragment2)
        }

        fragmentSignInBinding?.tvSignInSignUpScreen?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }
}