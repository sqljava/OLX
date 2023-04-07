package com.example.olx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olx.databinding.ProductItemBinding

class ProductAdapter(var list: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    class ProductHolder(binding : ProductItemBinding): RecyclerView.ViewHolder(binding.root){
        var name = binding.productName
        var price = binding.productPrice
        var liked = binding.productLiked

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.name.text = list[position].name
        holder.price.text = list[position].price.toString()


        holder.liked.setOnClickListener {
            if (list[position].isLiked){
                holder.liked.setImageResource(R.drawable.emptylove)
            }else{
                holder.liked.setImageResource(R.drawable.love)
            }
        }
    }
}