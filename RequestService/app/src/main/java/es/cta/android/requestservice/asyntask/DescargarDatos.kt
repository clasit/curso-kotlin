package es.cta.android.asincrona.asyntask


import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import com.google.gson.Gson
import es.cta.android.requestservice.models.User


/**
 * Descarga de datos
 **/

open class DescargarDatos(val ctx: Context, val broadcastName: String) : AsyncTask<String, Unit, String>() {

    override fun doInBackground(vararg params: String?): String {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(params[0])
            .build()

        val response = client.newCall(request).execute()

        val body: ResponseBody? = response.body()
        return body!!.string()
    }

    override fun onPostExecute(result: String?) {
        val gson = Gson()
        val userObject = gson.fromJson(result, Array<User>::class.java)

        val i = Intent()
        i.setAction(broadcastName)
        i.putExtra("datos", userObject)
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i)

    }
}