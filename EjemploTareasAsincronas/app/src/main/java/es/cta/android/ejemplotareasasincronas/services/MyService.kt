package es.cta.android.ejemplotareasasincronas.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import es.cta.android.ejemplotareasasincronas.asyntask.TareaAsincrona

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent?.getStringExtra("url")
        TareaAsincrona(this).execute(data)
        return START_NOT_STICKY
    }
}
