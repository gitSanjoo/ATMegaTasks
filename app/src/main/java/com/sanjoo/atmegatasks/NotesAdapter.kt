package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NotesAdapter (private val productList:ArrayList<Products>):
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
   private lateinit var mListener:OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener:OnItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item,parent,false)
        return NotesViewHolder(itemView ,mListener )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentProduct=productList[position]
        holder.image.setImageResource(currentProduct.productImage)
        holder.name.text=currentProduct.name
        holder.price.text=currentProduct.price.toString()
    }
    class NotesViewHolder(itemView: View,listenr:OnItemClickListener): RecyclerView.ViewHolder(itemView){

        val image: ShapeableImageView =itemView.findViewById(R.id.product_img)
        val name: TextView =itemView.findViewById(R.id.product_name)
        val price: TextView =itemView.findViewById(R.id.product_price)

        init {
             listenr.onItemClick(adapterPosition )
        }
    }


}