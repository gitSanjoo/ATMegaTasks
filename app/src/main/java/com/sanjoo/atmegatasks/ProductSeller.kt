 package com.sanjoo.atmegatasks

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

 class ProductSeller : AppCompatActivity() {

    val CHANNEL_ID="channelId"
    val CHANNEL_NAME="channelName"
     val NOTIFICATION_ID=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_seller)
        createNotificationChannel()

        val notificationButton=findViewById<Button>(R.id.SendNotification)

        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("ATMega Notification")
            .setContentText("this is a trial push notification")
            .setSmallIcon(R.drawable.camera)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManger=NotificationManagerCompat.from(this)
        notificationButton.setOnClickListener{
            notificationManger.notify(NOTIFICATION_ID,notification)
        }

    }

    fun createNotificationChannel(){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                val atMegahannel=NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH).apply {
                         lightColor=Color.BLUE
                    enableLights(true)
                }
                val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(atMegahannel )
            }
    }
}