package com.sanjoo.atmegatasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ToggleButton
import com.sanjoo.atmegatasks.databinding.ActivityMainBinding

class DarkLightModeSwitching : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view: View =binding.root
//        setContentView(view)
//

        setContentView(R.layout.activity_dark_light_mode_switching)
        var tb:ToggleButton = findViewById(R.id.toggle_btn_change_language)!!
        tb.setOnClickListener(View.OnClickListener {
            changeLanguage()
        })
    }

    private fun changeLanguage() {
        TODO("Not yet implemented")
    }
}