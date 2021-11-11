package com.judahben149.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.learnkotlin.adapters.ModulesRecyclerViewAdapter
import com.judahben149.learnkotlin.databinding.FragmentModulesBinding

class ModulesFragment : Fragment() {

    private var fragmentModulesBinding: FragmentModulesBinding? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ModulesRecyclerViewAdapter.ModulesRecyclerViewViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModulesBinding = FragmentModulesBinding.inflate(inflater, container, false)

        return fragmentModulesBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)
        adapter = ModulesRecyclerViewAdapter()

        fragmentModulesBinding?.rvModulesScreen?.layoutManager = layoutManager
        fragmentModulesBinding?.rvModulesScreen?.adapter = adapter

    }
}