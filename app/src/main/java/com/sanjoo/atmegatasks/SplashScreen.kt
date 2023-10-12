package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val img=findViewById<ImageView>(R.id.splash_image)
        img.alpha=0f
        img.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, CopyFlipkartActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}