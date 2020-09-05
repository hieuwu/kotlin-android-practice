package com.hieuwu.disneyworld

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.location.LocationListener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()
    }

    var ACCESSLOCATION = 123
    fun checkPermission() {
        if(Build.VERSION.SDK_INT >= 23) {
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCESSLOCATION)
                return
            }
        }
        GetUserLocation()
    }

    fun GetUserLocation() {
        Toast.makeText(this,"Location access allowed !", Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            ACCESSLOCATION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    GetUserLocation()
                } else {
                    Toast.makeText(this,"Location access now allowed !", Toast.LENGTH_LONG).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        var profileMarker = resizeMarkerIcon(R.drawable.insect,128,128)
        // Add a marker in Sydney and move the camera
        val saigon = LatLng(10.779, 106.699)
        mMap.addMarker(MarkerOptions().position(saigon).title("Me").snippet("Here is my location").icon(profileMarker))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saigon,14f))

    }

    private fun resizeMarkerIcon(id:Int, width: Int, height: Int): BitmapDescriptor {
        val bitmapDrawable = BitmapFactory.decodeResource(resources,id)
        val resizedBitmap = Bitmap.createScaledBitmap(bitmapDrawable,width,height,false)
        var iconInBitmap = BitmapDescriptorFactory.fromBitmap(resizedBitmap);
        return iconInBitmap
    }

    inner class MyLocationListener: LocationListener {
        var location:Location?=null
        constructor() {
            location = Location("Start")
            location!!.longitude = 0.0
            location!!.latitude = 0.0
        }
        override fun onLocationChanged(p0: Location?) {
            this.location = p0
    }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
           // TODO("Not yet implemented")
        }

        override fun onProviderEnabled(p0: String?) {
          //  TODO("Not yet implemented")
        }

        override fun onProviderDisabled(p0: String?) {
           // TODO("Not yet implemented")
        }

    }
}