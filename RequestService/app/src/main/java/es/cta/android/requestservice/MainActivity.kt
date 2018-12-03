package es.cta.android.requestservice


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import es.cta.android.asincrona.asyntask.DescargarDatos
import es.cta.android.requestservice.models.User

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LocalBroadcastManager.getInstance(this).registerReceiver(data, IntentFilter("ACCION_INTERNA"))

        btnDownloadUser.setOnClickListener {

            DescargarDatos(this, "ACCION_INTERNA").execute("https://jsonplaceholder.typicode.com/users")
        }
    }


    val data = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val userArray = intent!!.getSerializableExtra("datos")
        }
    }
}
