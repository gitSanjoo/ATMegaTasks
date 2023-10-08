package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CopyFlipkartActivity : AppCompatActivity() {
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
    }
}