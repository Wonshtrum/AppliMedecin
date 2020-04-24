package com.example.applimedecin

import android.os.AsyncTask

class DoAsync<type>(val handler: () -> type) : AsyncTask<Void, Void, Void>() {
    var end = false
    var result: type? = null
    override fun doInBackground(vararg params: Void?): Void? {
        result = handler()
        end = true
        return null
    }
    fun waitUntil(stepTime: Long = 100, maxTime: Int = 10, default: type? = null) : type? {
        end = false
        execute()
        var i = maxTime
        while(!end && i > 0) {
            i--
            Thread.sleep(stepTime)
        }
        return if (end) {
            result
        } else {
            default
        }
    }
}