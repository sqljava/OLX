package com.example.olx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olx.databinding.CategoryItemBinding

class CategoryAdapter(var list : MutableList<Category> , var categoryInterface: CategoryInterface) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    class CategoryHolder(binding : CategoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        var name = binding.categoryText
        var img = binding.categoryImg
        var main = binding.categoryMain

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.name.text = list[position].name
        holder.img.setImageResource(list[position].img)

        holder.main.setOnClickListener {
            categoryInterface.onClick(list[position])
        }

    }

    interface CategoryInterface{
        fun onClick(category: Category)
    }
}