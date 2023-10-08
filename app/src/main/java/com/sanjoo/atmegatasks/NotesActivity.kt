package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotesActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var list: ArrayList<Products>

    lateinit var img:Array<Int>
    lateinit var name:Array<String>
    lateinit var price:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        img= arrayOf(
            R.drawable.atmega,
            R.drawable.pic1,
            R.drawable.pic4
        )
        name= arrayOf(
            "fruits",
            "vegetables",
            "seeds"
        )
        price= arrayOf(
            "50rs/kg",
            "30rs/kg",
            "500rs/kg"
        )

        rv=findViewById(R.id.recycler)
        rv.layoutManager= GridLayoutManager(this,2)

        list= ArrayList<Products>()
        getProductData()
    }

    private fun getProductData() {
        for (i in img.indices){
            val products=Products(img[i],name[i],price[i])
            list.add(products )
        }
        var adap=NotesAdapter(list)
        rv.adapter=adap
        adap.setCustomItemSelectListener(object :NotesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                var i3= Intent(this@NotesActivity,ProductDetailActivity::class.java)
                    .putExtra("Name",name[position])
                    .putExtra("Image",img[position])
                    .putExtra("Price",price[position])
                startActivity(i3)
            }

        })
    }

}