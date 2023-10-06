package com.sanjoo.atmegatasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class AnnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annimation)

        val anim=findViewById<LottieAnimationView>(R.id.surprise)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
              anim.visibility=View.VISIBLE
            anim.playAnimation()
        },2000)
        
        anim.setOnClickListener{
            anim.playAnimation()
        }
    }
}