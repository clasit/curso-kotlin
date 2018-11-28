package es.cta.android.asincrona.asyntask


import android.os.AsyncTask
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody

class DescargarDatos() : AsyncTask<String, Unit, String>() {

    // Se ejecutará justo antes de lanzar el thread
    override fun onPreExecute() {
    }

    override fun doInBackground(vararg params: String?): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(params[0])
            .build()

        val response = client.newCall(request).execute()

        // La doble !!. Indicas que nunca será 'null'. Aunque body sea nullable ¿Que ventaja da?
        val body: ResponseBody? = response.body()
        return body!!.string()
    }

    // Se ejecutará después de terminar el thread
    // El resultado de 'doInBackground' recibe como parámetro en 'onPostExecute'
    override fun onPostExecute(result: String?) {
        Log.i("ASINC", result)
    }
}