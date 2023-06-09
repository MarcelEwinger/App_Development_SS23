package com.example.ue_9_ewinger_benischke

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        stop.isEnabled = false

        start.setOnClickListener {
            startTracking()
            start.isEnabled = false
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
            start.isEnabled = true
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onLocationChanged(p0: Location) {
        //Latitude/Longitude:
        lat = p0.latitude
        lon = p0.longitude
//        position.text =
//            "Latitude/Longitude:\n" + "%.8f".format(p0.latitude) + " / " + "%.8f".format(p0.longitude)
        position.text =
            "Latitude: ${p0.latitude}\nLongitude: ${p0.longitude}"


        if (latPrevious != 0.0 && lonPrevious != 0.0) {
            // sum meters up
            meters += convertToMeters(latPrevious, lonPrevious, lat, lon)
            distance.text = "Distance: %.2f".format(meters) + " m"
        }

        latPrevious = lat
        lonPrevious = lon
    }

    // check permission
    private fun startTracking() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2
            )
        }
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
}