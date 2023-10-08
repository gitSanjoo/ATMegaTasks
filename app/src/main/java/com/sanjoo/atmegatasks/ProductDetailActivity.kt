package com.sanjoo.atmegatasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var price:TextView
    private lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        name=findViewById(R.id.nameDetail)
        price=findViewById(R.id.priceDetail)
        image=findViewById(R.id.imageDetail)

        val nameDetail=intent.getStringExtra("Name")
        val priceDetail=intent.getStringExtra("Price")
        val imageDetail=intent.getStringExtra("Image")

        name.text=nameDetail
        price.text=priceDetail
//        image.setImageResource(imageDetail.)

//        val nameText=findViewById<TextView>(R.id.nameDetail).apply {
//            text=nameDetail
//        }
    }

}