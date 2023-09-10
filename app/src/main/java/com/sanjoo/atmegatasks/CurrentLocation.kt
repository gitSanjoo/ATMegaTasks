package com.sanjoo.atmegatasks

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

class CurrentLocation : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient:FusedLocationProviderClient
    private lateinit var latitude:TextView
    private lateinit var longitude:TextView
    private lateinit var city:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_location)

        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)
        latitude=findViewById(R.id.lat)
        longitude=findViewById(R.id.lon)
        city=findViewById(R.id.city)

        getUserLocation()
    }

    private fun getUserLocation() {
        if(checkPermissions()){
            if(isLocationEnabled()){

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this){ task->
                    val location: Location?=task.result
                    if (location==null){
                        Toast.makeText(applicationContext,"null received ",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext,"successfully ",Toast.LENGTH_SHORT).show()
                        val latt=location.latitude
                        latitude.text=""+latt
                        val longg=location.longitude
                        longitude.text=""+longg
                        city.setText(getCityName(latt,longg))

                    }

                }

            }else{
                //setting open here
                Toast.makeText(applicationContext,"turn on location",Toast.LENGTH_SHORT).show()
                val intent= Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }else{
            //request permission
            requestUserPermission()

        }
    }

    private fun isLocationEnabled(): Boolean {
            val locationManager:LocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                    locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun requestUserPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_REQUEST
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_COARSE_LOCATION)
        ==PackageManager.PERMISSION_GRANTED &&ActivityCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_FINE_LOCATION)
        ==PackageManager.PERMISSION_GRANTED
                ){
            return true}
            return false
    }

    companion object{
        private const val PERMISSION_REQUEST=100
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== PERMISSION_REQUEST){
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext,"permission granted",Toast.LENGTH_SHORT).show()
                getUserLocation()
            }else{
                Toast.makeText(applicationContext,"permission denied",Toast.LENGTH_SHORT).show()

            }
        }
    }
    fun getCityName(lt: Double, lg: Double):String {
        var cityName = ""
        var geocoder = Geocoder(this, Locale.getDefault())
        var address = geocoder.getFromLocation(lt.toDouble(), lg.toDouble(),3)

        if (address != null) {
            cityName=address.get(0).locality
        }
        return cityName
    }
}