package com.judahben149.learnkotlin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigation
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.activities.MainActivity
import com.judahben149.learnkotlin.databinding.FragmentAuthenticatedBinding


class AuthenticatedFragment : Fragment() {

    private var fragmentAuthenticatedBinding: FragmentAuthenticatedBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentAuthenticatedBinding = FragmentAuthenticatedBinding.inflate(inflater,container,false)

        return fragmentAuthenticatedBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentAuthenticatedBinding?.btnLogInSignInPage?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authenticatedFragment2_to_mainActivity)
        }
    }
}