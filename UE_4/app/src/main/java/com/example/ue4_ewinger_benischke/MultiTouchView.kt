package com.example.ue4_ewinger_benischke

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class MultiTouchView (context: Context, attrs: AttributeSet?) : View(context, attrs) {
    /**
     * neue Instanz der Klasse Paint, die verwendet wird, um Formen oder Text auf dem Bildschirm zu zeichnen
     * Hier wird die apply-Funktion verwendet, um den Stil der Farbe des Pinsels (Paint) zu setzen.
     * In diesem Fall wird Paint.Style.FILL gesetzt, was bedeutet, dass die Farbe auf der Fläche innerhalb
     * der Kontur gezeichnet wird, falls eine Kontur vorhanden ist.
     */
    private val paint = Paint().apply {
        style = Paint.Style.FILL

    }

    private val fingerPositions = mutableMapOf<Int, PointF>()//eine Map, die den Finger-IDs (als Integer) eine Koordinate als PointF (x und y) zuordnet
    private val fingerColors = mutableMapOf<Int, Int>()//eine Map, die den Finger-IDs eine Farbe als Integer zuordne
    //mutableMapOf-Funktion wird verwendet, um eine veränderbare Instanz einer Map zu erstellen,
    // die beim Ausführen der onTouchEvent-Funktion aktualisiert wird.

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                // A new finger has touched the screen
                val pointerIndex = event.actionIndex
                val pointerId = event.getPointerId(pointerIndex)
                val x = event.getX(pointerIndex)
                val y = event.getY(pointerIndex)
                fingerPositions[pointerId] = PointF(x, y)
                fingerColors[pointerId] = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            }
            MotionEvent.ACTION_MOVE -> {
                // One or more fingers have moved on the screen
                for (i in 0 until event.pointerCount) {
                    val pointerId = event.getPointerId(i)
                    val x = event.getX(i)
                    val y = event.getY(i)
                    fingerPositions[pointerId] = PointF(x, y)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                // A finger has been lifted off the screen
                val pointerId = event.getPointerId(event.actionIndex)
                fingerPositions.remove(pointerId)
                fingerColors.remove(pointerId)
            }
        }
        invalidate()
        return true
    }

    /**
     *
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the circles for each finger
        fingerPositions.forEach { (id, position) ->//loop to draw a cricle for each finger touch on the screen
            paint.color = fingerColors[id] ?: Color.BLACK
            canvas.drawCircle(position.x, position.y, 100f, paint)
        }
        // Draw the count of active fingers in the center of the screen
        paint.color = Color.BLACK
        paint.textSize = 200f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("${fingerPositions.size}", width / 2f, height / 2f, paint)
    }
}