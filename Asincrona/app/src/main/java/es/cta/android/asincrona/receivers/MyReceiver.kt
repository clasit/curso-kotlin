package es.cta.android.asincrona.receivers


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


/**----------------------------------------------------------------------
 * Un "Reciver" es una clase que es como un "Publicador/Subscriptor"
 * Se comunica a los subscriptores mediante "Send Broadcast"
 * Cuando al "Reciver" le llega una señal, este reacciona
 *----------------------------------------------------------------------*/

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("RECEIVER", "Estoy reaccionando a una acción!")
    }
}
