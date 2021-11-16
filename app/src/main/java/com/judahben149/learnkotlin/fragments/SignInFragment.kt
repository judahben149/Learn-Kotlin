package com.judahben149.learnkotlin.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignInBinding.inflate(layoutInflater,container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogInSignInScreen.setOnClickListener {

            when {
                TextUtils.isEmpty(binding.etEmailSignInPage.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.etPasswordSignInScreen.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = binding.etEmailSignInPage.text.toString().trim { it <= ' ' }
                    val password: String = binding.etPasswordSignInScreen.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    activity,
                                    "Logged in successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_authenticatedFragment2)
                            } else {
                                Toast.makeText(
                                    activity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }
                }
            }
        }

        binding.btnContinueWithGoogleSignInScreen.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_authenticatedFragment2)
        }

        binding.tvSignUpSignInScreen.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }
}