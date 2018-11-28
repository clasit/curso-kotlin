package es.cta.android.boundedservice.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class ServiceBounded : Service() {

    private val myBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    inner class MyBinder: Binder() {
        fun getServicd(): ServiceBounded {
            return this@ServiceBounded
        }
    }

    fun getData(): String {
        return "Datos desde servicio enlazado"
    }
}
