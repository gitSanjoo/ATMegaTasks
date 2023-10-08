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


    fun setCustomItemSelectListener(listener:OnItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.product_list_item,parent,false)
        return NotesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.onBind(holder.itemView,position)
    }
    inner class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val image: ShapeableImageView =itemView.findViewById(R.id.product_img)
        private val name: TextView =itemView.findViewById(R.id.product_name)
        private val price: TextView =itemView.findViewById(R.id.product_price)



        fun onBind(itemView: View,position:Int){
            val currentProduct=productList[position]
            image.setImageResource(currentProduct.productImage)
            name.text=currentProduct.name
            price.text= currentProduct.price
            itemView.setOnClickListener {
                mListener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}