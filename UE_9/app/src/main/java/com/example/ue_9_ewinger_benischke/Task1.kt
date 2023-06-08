package com.example.ue_9_ewinger_benischke

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import kotlin.math.roundToInt

class Task1 : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var xTextView : TextView
    private lateinit var yTextView : TextView
    private lateinit var ballX : ImageView
    private lateinit var ballY : ImageView
    private lateinit var ballXY : ImageView
    private val df: DecimalFormat = DecimalFormat("0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        xTextView = findViewById(R.id.xTextView)
        yTextView = findViewById(R.id.yTextView)
        ballX = findViewById(R.id.ball_x)
        ballY = findViewById(R.id.ball_y)
        ballXY = findViewById(R.id.ball_xy)

        setUpSensor()
    }

    private fun setUpSensor(){
        // SensorManager-Instanz abrufen
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Specify the sensor you want to listen to
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also { accelerometer ->
            sensorManager.registerListener(
                this,
                accelerometer,
                SensorManager.SENSOR_DELAY_GAME,
                SensorManager.SENSOR_DELAY_GAME
            )
        }

    }

    override fun onResume() {
        super.onResume()
        setUpSensor()
    }

    override fun onPause() {
        super.onPause()
        // Sensor-Listener entfernen, um Energie zu sparen
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Nicht verwendet
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]

            // X- und Y-Werte aktualisieren
            xTextView.text = "X-Achse: ${df.format(x * 10) }°"
            yTextView.text = "Y-Achse: ${df.format(y * 10)}°"

            // Bewegung der Kugel auf der X-Achse
            val xTranslation = (x * -30).roundToInt() // Multipliziere mit -10 für umgekehrte Richtung
            ballX.translationX = xTranslation.toFloat()

            // Bewegung der Kugel auf der Y-Achse
            val yTranslation = (y * -30).roundToInt() // Multipliziere mit -10 für umgekehrte Richtung
            ballY.translationY = yTranslation.toFloat()

            ballXY.translationY = yTranslation.toFloat()
            ballXY.translationX = xTranslation.toFloat()
        }
    }
}