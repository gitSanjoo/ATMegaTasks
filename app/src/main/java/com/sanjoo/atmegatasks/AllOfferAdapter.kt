package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AllOfferAdapter(private val offerList:ArrayList<OffersData>):RecyclerView.Adapter<AllOfferAdapter.AllOfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllOfferViewHolder {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.all_offer_item,parent,false)
        return AllOfferViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    override fun onBindViewHolder(holder: AllOfferViewHolder, position: Int) {
        val currentItem=offerList[position]

        holder.image.setImageResource(currentItem.productImage)
        holder.textOnImage.text=currentItem.name
    }

    inner class AllOfferViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val image:ImageView=itemView.findViewById(R.id.offer_image)
        val textOnImage:TextView=itemView.findViewById(R.id.offer_of_day_text)
    }

}