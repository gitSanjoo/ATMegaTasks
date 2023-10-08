package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ProductAdapter(private val productList:ArrayList<Products>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.product_list_item,parent,false)
        return ProductViewHolder(itemView )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct=productList[position]
        holder.image.setImageResource(currentProduct.productImage)
        holder.name.text=currentProduct.name
        holder.price.text=currentProduct.price.toString()
    }
    class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val image:ShapeableImageView=itemView.findViewById(R.id.product_img)
        val name:TextView=itemView.findViewById(R.id.product_name)
        val price:TextView=itemView.findViewById(R.id.product_price)
    }

}