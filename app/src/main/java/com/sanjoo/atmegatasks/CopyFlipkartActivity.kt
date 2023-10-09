package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class CopyFlipkartActivity : AppCompatActivity() {
    private lateinit var categoryList:ArrayList<CategoryDataClass>
    private lateinit var categoryRecyclerView:RecyclerView
    lateinit var imageCategory:Array<Int>
    lateinit var nameCategory:Array<String>

    private lateinit var offerList:ArrayList<OffersData>
    private lateinit var offerRecyclerView:RecyclerView
    lateinit var imageOffer:Array<Int>
    lateinit var nameOffer:Array<String>

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

        imageOffer= arrayOf(
            R.drawable.offer1,
            R.drawable.offer2,
            R.drawable.offer3,
            R.drawable.atmega,
            R.drawable.pic1,
            R.drawable.pic4
        )
        nameOffer= arrayOf(
            "offer 1",
            "offer 2",
            "offer 3",
            "fruits",
            "vegetables",
            "seeds"
        )
        offerRecyclerView=findViewById(R.id.all_offer_recyclerView)
        offerRecyclerView.layoutManager=GridLayoutManager(this,2)
        offerList= arrayListOf<OffersData>()

        getProductData()


        //viewpager
        imageOffer= arrayOf(
            R.drawable.offer1,
            R.drawable.offer2,
            R.drawable.offer3,
            R.drawable.atmega,
            R.drawable.pic1,
            R.drawable.pic4
        )

        val viewPagerImages= listOf(
            R.drawable.offer3,
            R.drawable.offer1,
            R.drawable.offer2,

        )
        val vpAdapter=OfferViewPagerAdapter(viewPagerImages)
        val viewPager=findViewById<ViewPager2>(R.id.offer_viewPager)
        viewPager.adapter=vpAdapter

        viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-30f)
        viewPager.endFakeDrag()

        //viewpager circle indicator
        val indicator=findViewById<CircleIndicator3>(R.id.circleIndicator3)
        indicator.setViewPager(viewPager)

    }

    private fun getCategoryData() {
        for(i in imageCategory.indices){
            val catData=CategoryDataClass(imageCategory[i],nameCategory[i])
            categoryList.add(catData)
        }
        categoryRecyclerView.adapter=CategoryCardAdapter(categoryList )
    }
    private  fun getProductData() {
        for (i in imageOffer.indices){
            val offers=OffersData(imageOffer[i],nameOffer[i])
            offerList.add(offers)
        }
        offerRecyclerView.adapter=AllOfferAdapter(offerList)
    }

}