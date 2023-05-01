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
    private val paint = Paint().apply {
        style = Paint.Style.FILL

    }

    private val fingerPositions = mutableMapOf<Int, PointF>()
    private val fingerColors = mutableMapOf<Int, Int>()

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

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the circles for each finger
        fingerPositions.forEach { (id, position) ->
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