package com.sanjoo.atmegatasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat

class CurrentLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
            ),0
            )
        setContentView(R.layout.activity_current_location)
        val btnStart:Button=findViewById(R.id.start)
        val btnStop:Button=findViewById(R.id.stop)

        btnStart.setOnClickListener(View.OnClickListener {
            Intent(applicationContext,LocationService::class.java).apply {
                action=LocationService.ACTION_START
                startService(this)
            }
        })
        btnStop.setOnClickListener(View.OnClickListener {
            Intent(applicationContext,LocationService::class.java).apply {
                action=LocationService.ACTION_STOP
                startService(this )
            }
        })
    }
}