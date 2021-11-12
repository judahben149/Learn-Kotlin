package com.judahben149.learnkotlin.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.ItemLayoutModulesRvBinding
import com.judahben149.learnkotlin.model.ModulesList

class ModulesRecyclerViewAdapter(): RecyclerView.Adapter<ModulesRecyclerViewAdapter.ModulesRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModulesRecyclerViewViewHolder {
        val binding = ItemLayoutModulesRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModulesRecyclerViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModulesRecyclerViewViewHolder, position: Int) {

        holder.bindItem(position)

    }

    override fun getItemCount(): Int {
        return moduleNos.size
    }


    companion object{
        var moduleNos = arrayListOf<String>("Module One", "Module Two", "Module Three", "Module Four", "Module Five", "Module Six", "Module Seven",
            "Module Eight", "Module Nine", "Module Ten", "Module Eleven", "Module Twelve", "Module Thirteen", "Module Fourteen", "Module Fifteen", "Module Sixteen",
            "Module Seventeen", "Module Eighteen", "Module Nineteen", "Module Twenty", "Module Twenty-one")


        var moduleTitles = arrayListOf<String>("Introduction", "Get Started", "Syntax", "Output", "Comments", "Variables", "Data Types", "Operators", "Strings", "Booleans", "If ... Else",
            "When Statements", "While Loops", "Break and Continue", "Arrays", "For Loops", "Ranges", "Functions", "Object-Oriented Programming", "Classes and Objects",
                "Constructors")

    }

    inner class ModulesRecyclerViewViewHolder(private val binding: ItemLayoutModulesRvBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(position: Int){
            binding.tv1ItemView.text = moduleNos[position]
            binding.tv2ItemView.text = moduleTitles[position]

            binding.cardViewItem.setOnClickListener {
                val title = moduleNos[position]
                val description = moduleTitles[position]
                val bundle = Bundle()
                bundle.putString("TITLE", title)
                bundle.putString("DESC", description)
//                bundle.putParcelable()
                Navigation.findNavController(binding.root).navigate(R.id.action_modulesFragment_to_moduleDetailsFragment, bundle)
            }
        }

    }


}


