package es.cta.android.asincrona

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import android.os.AsyncTask.execute




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DescargarDatos().execute("https://developer.android.com")
    }


    private class DescargarDatos(): AsyncTask<String, Unit, String>() {

        // Se ejecutará justo antes de lanzar el thread
        override fun onPreExecute() {
        }

        override fun doInBackground(vararg params: String?): String {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(params[0])
                .build()

            val response = client.newCall(request).execute()
            return response.body().toString()
        }

        // Se ejecutará después de terminar el thread
        // El resultado de 'doInBackground' recibe como parámetro en 'onPostExecute'
        override fun onPostExecute(result: String?) {
            Log.i("ASINC", result)
        }
    }
}
