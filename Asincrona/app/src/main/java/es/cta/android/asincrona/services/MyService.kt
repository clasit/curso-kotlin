package es.cta.android.asincrona.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import es.cta.android.asincrona.asyntask.DescargarDatos

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("CREATE", "Creación servicio MyService")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("SERVICE", "Inicio proceso del servico MyService")

        DescargarDatos().execute("https://developer.android.com")

        // START_STICKY: Si el servicio se vuelve a levantar
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SERVICE", "Fin del servico MyService")
    }
}
