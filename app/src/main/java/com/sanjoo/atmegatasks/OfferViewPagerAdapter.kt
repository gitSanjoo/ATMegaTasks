package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class OfferViewPagerAdapter(val imageList:List<Int>):RecyclerView.Adapter<OfferViewPagerAdapter.OfferViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewPagerViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return OfferViewPagerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: OfferViewPagerViewHolder, position: Int) {
        val currentImage=imageList[position]
        holder.image.setImageResource(currentImage)
    }

    inner class OfferViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val image:ImageView=itemView.findViewById(R.id.viewPagerImageView)
    }

}