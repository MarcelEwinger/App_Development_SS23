package com.example.ue4_ewinger_benischke

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar

class SingleTouchView (context: Context, attrs: AttributeSet?) : View(context, attrs), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener  {

    private var mDetector: GestureDetector = GestureDetector(context, this)
    private val DEBUG_TAG = "Gestures"
    private var view = findViewById<View>(R.id.singleTouchView)



    fun showSnackbar(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }


    /**
     * Returns true if motion event was consumed.
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    /**
     * Called when a down motion event was detected (e.g., as start for a tap)
     */
    override fun onDown(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDown: $event")
        showSnackbar(view, "onDown")
        return true
    }

    /**
     * Called when a fling (swipe) gesture was detected.
     * e1 and e2 are down and up motion events.
     * Velocity is in pixels per second.
     */
    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onFling: $event1 $event2")
        showSnackbar(view, "onFling")
        return true
    }

    /**
     * Called when a long press gesture was detected
     * e is the down motion event the gesture started with
     */
    override fun onLongPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onLongPress: $event")
        showSnackbar(view, "onLongPress")
    }

    /**
     * Called when a scroll gesture was detected
     * e1 and e2 are down and current move motion events
     */
    override fun onScroll(
        event1: MotionEvent,
        event2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onScroll: $event1 $event2")
        showSnackbar(view, "onScroll")
        return true
    }

    /**
     * Called when a down motion event was detected, but
     * the up motion event has not been detected yet
     */
    override fun onShowPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onShowPress: $event")
        showSnackbar(view, "onShowPress")
    }

    /**
     * Called when a tap gesture was detected
     * e is the up motion event the gesture start with
     */
    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapUp: $event")
        showSnackbar(view, "onSingleTapUp")
        return true
    }

    /**
     * Called when a double-tap was detected
     */
    override fun onDoubleTap(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTap: $event")
        showSnackbar(view, "onDoubleTap")
        return true
    }

    /**
     * Called for every event of a double-tap, such as down, move, and up.
     */
    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: $event")
        showSnackbar(view, "onDoubleTapEvent")
        return true
    }

    /**
     * Called as soon as gesture detector is sure that it is not a double-tap.
     */
    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: $event")
        showSnackbar(view, "onSingleTapConfirmed")
        return true
    }
}