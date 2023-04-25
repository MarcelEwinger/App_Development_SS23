package com.example.ue3_ewinger_benischke

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log


class AudioService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    //Late-initialized
    /*
    Normally, properties declared as having a non-null type must be initialized in the constructor
     */


    /**
     * Schnittstelle zwischen Aktivität und Service
     */
    override fun onBind(p0: Intent?): IBinder? {
        Log.i(TAG, "onBind")
        return null;
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
        //isLooping property to true so that the audio file loops continuously.
    }

    /**
     * Start Playback the audio file using medaPlayer.start().
     * Start_STICKY --> service will be automatically restarted if it is killed by the system.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand")
        mediaPlayer.start()
        return START_STICKY
    }

    /**
     * onDestroy() method, stop and release the MediaPlayer object to free up system resources
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
        mediaPlayer.stop()
        mediaPlayer.release()
    }


}