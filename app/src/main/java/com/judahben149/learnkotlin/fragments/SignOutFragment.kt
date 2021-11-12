package com.judahben149.learnkotlin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.judahben149.learnkotlin.activities.AuthenticationActivity

class SignOutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val intent = Intent(activity, AuthenticationActivity::class.java)
        startActivity(intent)
        return null
    }

}