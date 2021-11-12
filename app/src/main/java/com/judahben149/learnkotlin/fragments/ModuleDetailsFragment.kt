package com.judahben149.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.FragmentModuleDetailsBinding


class ModuleDetailsFragment : Fragment() {


    private lateinit var binding: FragmentModuleDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModuleDetailsBinding.inflate(inflater, container, false)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val bundle = arguments
        binding.moduleTitle.text = bundle?.getString("TITLE")
        binding.moduleDescription.text = getString(bundle!!.getInt("DESC"))
        binding.imageView2.setImageResource(bundle.getInt("IMAGE"))

        return binding.root
    }

}