package com.example.ue3_ewinger_benischke

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    private val prefs = context.getSharedPreferences("mySettings", Context.MODE_PRIVATE)

    fun savePref(key: String, value: String) {
        with (prefs.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getPref(key: String, default: String = ""): String {
        return prefs.getString(key, default) ?: ""
    }

    fun contains(key: String): Boolean {
        return prefs.contains(key)
    }
}
