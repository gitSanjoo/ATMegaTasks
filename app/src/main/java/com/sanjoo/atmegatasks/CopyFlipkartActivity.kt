package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CopyFlipkartActivity : AppCompatActivity() {
    private lateinit var categoryList:ArrayList<CategoryDataClass>
    private lateinit var categoryRecyclerView:RecyclerView
    lateinit var imageCategory:Array<Int>
    lateinit var nameCategory:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_copy_flipkart)

        val card1=findViewById<CardView>(R.id.card_view1)
        card1.setOnClickListener{
          val i1 =  Intent(this,ProductsActivity::class.java)
            startActivity(i1)
        }
        val card2=findViewById<CardView>(R.id.card_view2)
        card2.setOnClickListener{
          val i2 =  Intent(this,NotesActivity::class.java)
            startActivity(i2)
        }

        imageCategory= arrayOf(
            R.drawable.atmega,
            R.drawable.pic4,
            R.drawable.atmega,
            R.drawable.pic1,
            R.drawable.atmega,
        )
        nameCategory= arrayOf(
            "pic1",
            "pic2",
            "pic3",
            "pic4",
            "pic5 ",
        )
        categoryRecyclerView=findViewById(R.id.category_card_recyclerView)
        categoryRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        categoryList= arrayListOf<CategoryDataClass>()

        getCategoryData()

    }

    private fun getCategoryData() {
        for(i in imageCategory.indices){
            val catData=CategoryDataClass(imageCategory[i],nameCategory[i])
            categoryList.add(catData)
        }
        categoryRecyclerView.adapter=CategoryCardAdapter(categoryList )
    }
}