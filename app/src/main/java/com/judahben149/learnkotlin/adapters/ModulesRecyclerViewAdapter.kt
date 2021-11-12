package com.judahben149.learnkotlin.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.learnkotlin.R
import com.judahben149.learnkotlin.databinding.ItemLayoutModulesRvBinding

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


        var moduleSnippets = arrayListOf<String>("Introduction", "Get Started", "Syntax", "Output", "Comments", "Variables", "Data Types", "Operators", "Strings", "Strings",
        "Booleans", "If ... Else", "When Statements", "While Loops", "Break and Continue", "Arrays", "For Loops", "Ranges", "Functions", "Object-Oriented Programming",
        "Classes and Objects", "Constructors")


        var moduleContent = arrayListOf(R.string.module1_content, R.string.module2_content, R.string.module3_content, R.string.module4_content, R.string.module5_content,
            R.string.module6_content, R.string.module7_content, R.string.module8_content, R.string.module9_content, R.string.module10_content, R.string.module11_content,
            R.string.module12_content, R.string.module13_content, R.string.module14_content, R.string.module15_content, R.string.module16_content, R.string.module17_content,
            R.string.module18_content, R.string.module19_content, R.string.module20_content,
            R.string.module21_content)

        var moduleImage = arrayListOf<Int>(R.drawable.module1, R.drawable.module2, R.drawable.module3, R.drawable.module4, R.drawable.module5,
            R.drawable.module6, R.drawable.module7, R.drawable.module8, R.drawable.module9, R.drawable.module10, R.drawable.module11, R.drawable.module12,
            R.drawable.module13, R.drawable.module14, R.drawable.module15, R.drawable.module16, R.drawable.module17, R.drawable.module18,
            R.drawable.module19, R.drawable.module20, R.drawable.module21)
    }

    inner class ModulesRecyclerViewViewHolder(private val binding: ItemLayoutModulesRvBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(position: Int){
            binding.tv1ItemView.text = moduleNos[position]
            binding.tv2ItemView.text = moduleSnippets[position]

            binding.cardViewItem.setOnClickListener {
                val title = moduleSnippets[position]
                val description = moduleContent[position]
                val image = moduleImage[position]
                val bundle = Bundle()
                bundle.putString("TITLE", title)
                bundle.putInt("DESC", description)
                bundle.putInt("IMAGE", image)
                Navigation.findNavController(binding.root).navigate(R.id.action_modulesFragment_to_moduleDetailsFragment, bundle)
            }
        }

    }


}


