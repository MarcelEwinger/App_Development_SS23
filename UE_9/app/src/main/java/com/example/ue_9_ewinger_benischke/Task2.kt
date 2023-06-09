package com.example.ue_9_ewinger_benischke

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


class Task2 : AppCompatActivity(), LocationListener {

    private lateinit var start: Button
    private lateinit var stop: Button
    private lateinit var position: TextView
    private lateinit var distance: TextView
    private lateinit var locationManager: LocationManager
    private var meters: Double = 0.0
    private var latPrevious: Double = 0.0
    private var lonPrevious: Double = 0.0
    private var lat: Double = 0.0
    private var lon: Double = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        start = findViewById(R.id.btnStartTracking)
        stop = findViewById(R.id.btnEndTracking)
        position = findViewById(R.id.tvLatitudeLongitude)
        distance = findViewById(R.id.tvDistance)

        //set Stop Button to disabled
        stop.isEnabled = false



        start.setOnClickListener {
            startTracking()
            //set  Start Button to disabled
            start.isEnabled = false
            //set StopButton to enabled
            stop.isEnabled = true
        }

        stop.setOnClickListener {
            locationManager.removeUpdates(this)
            position.text = "Latitude: 0.0\nLongitude: 0.0"
            Toast.makeText(this, "You travelled %.2f".format(meters) + " meters",Toast.LENGTH_SHORT).show()
            meters = 0.0
            latPrevious = 0.0
            lonPrevious = 0.0
            distance.text = "Distance: $meters m"
            //set Start Button to enabled
            start.isEnabled = true
        }
    }

    /**
     * method is called when a new location update is available.
     */
    @SuppressLint("SetTextI18n")
    override fun onLocationChanged(p0: Location) {
        //get information from the p0 Object
        lat = p0.latitude //die Geographische Breite
        lon = p0.longitude//die Geographische Länge

        //set Text
        position.text = "Latitude: ${p0.latitude}\nLongitude: ${p0.longitude}"


        if (latPrevious != 0.0 && lonPrevious != 0.0) {
            // sum meters up
            meters += convertToMeters(latPrevious, lonPrevious, lat, lon)
            distance.text = "Distance: %.2f".format(meters) + " m"
        }

        latPrevious = lat
        lonPrevious = lon
    }


    /**
     * Starts the location tracking.
     */
    private fun startTracking() {
        //get locationManager Instance
        //The LocationManager is responsible for tracking the location of the device.
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        /*
        It checks whether the ACCESS_FINE_LOCATION permission has already been granted.
        If not, a permission request is made via requestPermissions()
        to give the user permission to use the exact location of the device.
         */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                2
            )
        }
        //Receive location updates from the LocationManager GPS provider.
        //minTime --> min Time between location update
        //minDistance --> minimum interval between updates in meters
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f, this)
    }

    // calculate meters from the latitude and the longitude: https://en.wikipedia.org/wiki/Haversine_formula
    // https://stackoverflow.com/questions/639695/how-to-convert-latitude-or-longitude-to-meters
    private fun convertToMeters(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val earthRadiusInKM = 6378.137
        val dLat = lat2 * Math.PI / 180 - lat1 * Math.PI / 180;
        val dLon = lon2 * Math.PI / 180 - lon1 * Math.PI / 180;
        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(lat1 * Math.PI / 180) * cos(lat2 * Math.PI / 180) *
                sin(dLon / 2) * sin(dLon / 2);
        val c = 2 * atan2(sqrt(a), sqrt(1 - a));
        val d = earthRadiusInKM * c;
        return d * 1000; // meters
    }

    override fun onProviderEnabled(provider: String) {}

    override fun onProviderDisabled(provider: String) {}

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
}