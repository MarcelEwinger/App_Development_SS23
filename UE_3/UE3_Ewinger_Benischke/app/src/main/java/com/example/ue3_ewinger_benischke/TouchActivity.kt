package com.example.ue3_ewinger_benischke

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random
import kotlin.math.*

class TouchActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private lateinit var btnRandomPoint: Button
    private lateinit var surfaceView: SurfaceView
    private lateinit var surfaceHolder: SurfaceHolder

    private var circleX = 0f
    private var circleY = 0f
    private var radius = 50
    private var distance = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch)

        btnRandomPoint = findViewById(R.id.btn_random_point)
        surfaceView = findViewById(R.id.surface_view)
        surfaceHolder = surfaceView.holder
        surfaceHolder.addCallback(this)

        btnRandomPoint.setOnClickListener {
            drawRandomCircle()
        }
    }

    //Die drei Overwrites werden nicht verwendet, müssen aber implementiert werden
    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

    private fun drawRandomCircle() {
        val canvas = surfaceHolder.lockCanvas()
        canvas.drawColor(Color.BLACK)

        val random = Random()
        circleX = (random.nextInt(canvas.width - radius * 2) + radius).toFloat()
        circleY = (random.nextInt(canvas.height - radius * 2) + radius).toFloat()

        val paint = Paint()
        paint.color = Color.BLUE
        canvas.drawCircle(circleX, circleY, radius.toFloat(), paint)

        surfaceHolder.unlockCanvasAndPost(canvas)
    }

    private fun calculateDistance(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        return sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))
    }

    private fun isTouchWithinCircle(touchX: Float, touchY: Float, circleX: Float, circleY: Float, radius: Int): Boolean {
        distance = floor(calculateDistance(touchX, touchY, circleX, circleY))
        return distance <= radius
    }

    private fun eraseCircle(canvas: Canvas) {
        // Lösche den Kreis, indem er mit der Hintergrundfarbe übermalt wird
        canvas.drawColor(Color.BLACK, PorterDuff.Mode.SRC_OVER)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val relativeLayout = findViewById<RelativeLayout>(R.id.RelativeLayout)

        val location = IntArray(2)
        relativeLayout.getLocationOnScreen(location)
        val relativeLayoutY = location[1]


        if (event.action == MotionEvent.ACTION_DOWN) {
            val touchX = event.x
            val touchY = event.y - relativeLayoutY - surfaceView.top

            val canvas = surfaceHolder.lockCanvas()
            val paint = Paint()


            if (isTouchWithinCircle(touchX, touchY, circleX, circleY, radius)) {
                // Touch event is within the circle
                paint.color = Color.GREEN
                eraseCircle(canvas)
                canvas.drawCircle(circleX, circleY, radius.toFloat(), paint)
                Toast.makeText(this, "Wow you are very good, you were only $distance pixels away", Toast.LENGTH_SHORT).show()
            } else {
                // Touch event is outside the circle
                paint.color = Color.RED
                eraseCircle(canvas)
                canvas.drawCircle(circleX, circleY, radius.toFloat(), paint)
                Toast.makeText(this, "Well you should try again, you were $distance pixels away", Toast.LENGTH_SHORT).show()
            }

            surfaceHolder.unlockCanvasAndPost(canvas)
        }

        return true
    }

}

