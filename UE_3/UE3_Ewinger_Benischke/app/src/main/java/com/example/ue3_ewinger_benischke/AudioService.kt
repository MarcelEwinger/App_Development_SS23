package com.example.ue3_ewinger_benischke

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class AudioService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    //Late-initialized
    /*
    Normally, properties declared as having a non-null type must be initialized in the constructor
     */

    override fun onBind(p0: Intent?): IBinder? {
        return null;
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
        //isLooping property to true so that the audio file loops continuously.
    }

    /**
     * Start Playback the audio file using medaPlayer.start().
     * Start_STICKY --> service will be automatically restarted if it is killed by the system.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()
        return START_STICKY
    }

    /**
     * onDestroy() method, we stop and release the MediaPlayer object to free up system resources
     */
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }


}