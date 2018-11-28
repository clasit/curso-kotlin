package es.cta.android.asincrona.services


import android.app.IntentService
import android.content.Intent
import android.util.Log
import es.cta.android.asincrona.asyntask.DescargarDatos

/** ----------------------------------------------------------------------------------------
 * El IntentService crea un nuevo thread, mientras que Service trabaja en el thread principal
 *
 * Un IntentService se destruy al terminar la tarea
 ** ---------------------------------------------------------------------------------------*/

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val url = intent?.getStringExtra("url")
        DescargarDatos().execute(url)
        // Log.i("INTENT_SERV", "Dato recibido por IS es '${data}'")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("onStartCommand", "IntentService")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("CREATE", "Creación servicio IntentService")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SERVICE", "Fin del servico IntentService")
    }
}
