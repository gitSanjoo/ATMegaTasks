package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryCardAdapter(private val catList:ArrayList<CategoryDataClass>):RecyclerView.Adapter<CategoryCardAdapter.CategoryCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryCardViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.category_card_item,parent,false)
        return  CategoryCardViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    override fun onBindViewHolder(holder: CategoryCardViewHolder, position: Int) {
        val currentItem=catList[position]
        holder.categoryImage.setImageResource(currentItem.imageCardCategory)
        holder.categoryName.text=currentItem.nameCategoryCard
    }
    inner class CategoryCardViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val categoryName:TextView=itemView.findViewById(R.id.name_category)
        val categoryImage:ImageView=itemView.findViewById(R.id.image_category )

    }
}