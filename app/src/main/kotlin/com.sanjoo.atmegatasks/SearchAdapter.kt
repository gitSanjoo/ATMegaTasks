package com.sanjoo.atmegatasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SearchAdapter(var sList: List<SearchData>,private  val textDataInterface:TextDataInterface): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){
//    val pos:Int=1


    inner class SearchViewHolder(itemView:View): ViewHolder(itemView){
        val sText:TextView=itemView.findViewById<TextView>(R.id.tv_text)
        val sArrow:ImageView=itemView.findViewById<ImageView>(R.id.icon_search_arrow)
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
        holder.itemView.setOnClickListener(View.OnClickListener {
            textDataInterface.getText(sList[position].textData)
        })


//        holder.sText.setOnClickListener(View.OnClickListener {
//        })
//        holder.sArrow.setOnClickListener(View.OnClickListener {
//            val pos=sList[position].textData
//
//        })
    }
//   fun getPosition():Int{
//        return pos
//    }
}