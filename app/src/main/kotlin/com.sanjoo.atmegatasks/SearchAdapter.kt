package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SearchAdapter(var sList: List<SearchData>): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    inner class SearchViewHolder(itemView:View): ViewHolder(itemView){
        val sText:TextView=itemView.findViewById<TextView>(R.id.tv_text)
    }
     fun setFilteredList(list: List<SearchData>){
        this.sList=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
    return sList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.sText.text=sList[position].textData
    }
}