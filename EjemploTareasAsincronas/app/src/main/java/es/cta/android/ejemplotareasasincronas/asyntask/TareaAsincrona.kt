package es.cta.android.ejemplotareasasincronas.asyntask

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

class TareaAsincrona(val ctx: Context): AsyncTask<String, Unit, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String?): String {
        return params[0] as String
    }

    override fun onPostExecute(result: String?) {
        val i: Intent = Intent("ACCION_INTERNA")
        i.putExtra("RESULT", result)
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i)
    }
}