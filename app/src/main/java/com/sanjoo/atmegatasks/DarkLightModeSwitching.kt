package com.sanjoo.atmegatasks

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import java.util.Locale

class DarkLightModeSwitching : AppCompatActivity() {

    private lateinit var modeSwitch:SwitchCompat
    private var nightMode:Boolean=false
    private var modeEditor:SharedPreferences.Editor?=null
    private var sharedPreferencesMode:SharedPreferences?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale()

        setContentView(R.layout.activity_dark_light_mode_switching)
 //code for mode change
        modeSwitch=findViewById(R.id.mode_switch)!!
        sharedPreferencesMode=getSharedPreferences("MODE",Context.MODE_PRIVATE)
        nightMode=sharedPreferencesMode?.getBoolean("night",false)!!
        if (nightMode){
            modeSwitch.isChecked=true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        modeSwitch.setOnCheckedChangeListener{compoundButton,state->
            if (nightMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                modeEditor=sharedPreferencesMode?.edit()
                modeEditor?.putBoolean("night",false)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                modeEditor=sharedPreferencesMode?.edit()
                modeEditor?.putBoolean("night",true)
            }
            modeEditor?.apply()
        }

//code for language translate

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
