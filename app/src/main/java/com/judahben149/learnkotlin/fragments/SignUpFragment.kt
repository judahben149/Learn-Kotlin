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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {


    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUpSignUpScreen.setOnClickListener {

            when {

                //checks if name field is empty
                TextUtils.isEmpty(binding.etNameSignUpPage.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        activity,
                        "Please enter name",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                //Checks if email field is empty
                TextUtils.isEmpty(binding.etEmailSignUpPage.text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                //Checks if password field is empty
                TextUtils.isEmpty(binding.etCreatePasswordSignUpPage.text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please create password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                //Checks if password confirmation field is empty
                TextUtils.isEmpty(binding.etConfirmPasswordSignUpPage.text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please confirm password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                //Checks if both passwords match
                binding.etCreatePasswordSignUpPage.text.toString().trim {it <= ' '} != binding.etConfirmPasswordSignUpPage.text.toString().trim {it <= ' '} -> {
                    Toast.makeText(
                        activity,
                        "Passwords must match",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = binding.etEmailSignUpPage.text.toString().trim {it <= ' '}
                    val password: String = binding.etCreatePasswordSignUpPage.text.toString().trim { it<= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            //if registration is successfully done
                            if (task.isSuccessful) {

                                //Firebase registered user
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    activity,
                                    "You were registered successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                Navigation.findNavController(view)
                                    .navigate(R.id.action_signUpFragment_to_authenticatedFragment2)

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

        binding.tvSignInSignUpScreen.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_signInFragment)
        }

    }


}