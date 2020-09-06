package com.hieuwu.disneyworld

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
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
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    var listCharacters = ArrayList<DisneyCharacter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        LoadCharacter ()
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
        var myLocation = MyLocationListener()
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3,3f,myLocation)
        var myThread = myThread()
        myThread.start()

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

    }

    private fun resizeMarkerIcon(id:Int, width: Int, height: Int): BitmapDescriptor {
        val bitmapDrawable = BitmapFactory.decodeResource(resources,id)
        val resizedBitmap = Bitmap.createScaledBitmap(bitmapDrawable,width,height,false)
        var iconInBitmap = BitmapDescriptorFactory.fromBitmap(resizedBitmap);
        return iconInBitmap
    }
    var location:Location?=null
    inner class MyLocationListener: LocationListener {
        constructor() {
            location = Location("Start")
            location!!.longitude = 0.0
            location!!.latitude = 0.0
        }
        override fun onLocationChanged(p0: Location?) {
            location = p0
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

    var oldLocation:Location ?= null
    inner class myThread: Thread {
        constructor():super() {
            oldLocation = Location("Start")
            oldLocation!!.latitude = 0.0
            oldLocation!!.longitude = 0.0
        }
        override fun run() {
            while (true) {
                try {
                    if (oldLocation!!.distanceTo(location) == 0f) {
                        continue
                    }
                    oldLocation = location
                    runOnUiThread {
                        mMap!!.clear()
                        var profileMarker = resizeMarkerIcon(R.drawable.profile,200,200)
                        val currentLocation = LatLng(location!!.latitude, location!!.longitude)
                        mMap.addMarker(MarkerOptions().position(currentLocation).title("Me").snippet("Here is my location").icon(profileMarker))
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,2f))
                        for(i in 0 until listCharacters.size) {
                            var aCharacter = listCharacters.get(i)
                            var characterMarker = resizeMarkerIcon(aCharacter.image!!,200,200)
                            val characterLocation = LatLng(aCharacter.location!!.latitude,aCharacter.location!!.longitude)
                            mMap.addMarker(MarkerOptions().position(characterLocation).title(aCharacter.name).snippet(aCharacter.description).icon(characterMarker))
                            if (location!!.distanceTo(aCharacter.location) < 600) {
                                Toast.makeText(applicationContext,"You met "+ aCharacter.name,Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    Thread.sleep(1000)
                } catch(ex: Exception) {

                }
            }
        }
    }

    fun LoadCharacter () {
        listCharacters.add(DisneyCharacter(R.drawable.americandragon, "American Dragon", "A Dragon Boy",37.9883, -115.0221))
        listCharacters.add(DisneyCharacter(R.drawable.ariel, "Ariel", "Sea Princess",37.6608, -114.5243 ))
        listCharacters.add(DisneyCharacter(R.drawable.bambi, "Bambi", "Jungle Prince",38.0099, -115.1220))
        listCharacters.add(DisneyCharacter(R.drawable.pluto, "Pluto", "Good dog",37.9263, -115.1390 ))
        listCharacters.add(DisneyCharacter(R.drawable.goofy, "Goofy", "Best friend",37.8877,  -115.1490 ))
        listCharacters.add(DisneyCharacter(R.drawable.donald, "Donald", "Nice friend",37.8447, -115.0580 ))
    }
}