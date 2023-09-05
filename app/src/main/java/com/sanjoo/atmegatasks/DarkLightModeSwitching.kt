package com.sanjoo.atmegatasks

import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import java.util.Locale

class DarkLightModeSwitching : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadLocale()

        setContentView(R.layout.activity_dark_light_mode_switching)
        var et:TextView=findViewById((R.id.et_word))
        var tb: ToggleButton = findViewById(R.id.toggle_btn_change_language)!!


        tb.setOnClickListener(View.OnClickListener {

            if (tb.isChecked) {
                setLocate("hi")
                recreate()
            }else{
                setLocate("en")
                recreate()
            }
        })
    }
    fun setLocate(lan: String){
        var locale=Locale(lan)
        var config=Configuration()
        config.locale=locale

        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)

        val editor:SharedPreferences.Editor=getSharedPreferences("setting", MODE_PRIVATE).edit()
        editor.putString("app_lan",lan)
        editor.apply()

    }
    fun loadLocale(){
        val sharerdPrefrence:SharedPreferences=getSharedPreferences("setting", MODE_PRIVATE)
        val lang: String? =sharerdPrefrence.getString("app_lan","")
        if (lang != null) {
            setLocate(lang)
        }
    }
}
