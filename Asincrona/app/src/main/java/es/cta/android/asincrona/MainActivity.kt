package es.cta.android.asincrona


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import es.cta.android.asincrona.services.MyIntentService
import es.cta.android.asincrona.services.MyService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInicioServicio.setOnClickListener {
            val intent: Intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        btnFinServicio.setOnClickListener {
            val intent: Intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        btnInicioIntentService.setOnClickListener {
            val intent: Intent = Intent(this, MyIntentService::class.java)
            intent.putExtra("url", "https://developer.android.com")
            startService(intent)
        }

        btnEnviarDatos.setOnClickListener {
            val intent: Intent = Intent("ACCION_INTERNA")
            sendBroadcast(intent)

            /* Intent().also { intent ->
                intent.setAction("ACCION_INTERNA")
                sendBroadcast(intent)
            } */

            /* Intent().also { intent ->
                intent.setAction("com.example.broadcast.MY_NOTIFICATION")
                intent.putExtra("data", "Notice me senpai!")
                sendBroadcast(intent)
            } */
        }

        /**
         * val i: Intent = Intent(this, MyIntentService::class.java)
         * startActivityForResult(i, 2)
         ***/
    }


    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(listener, IntentFilter("ACCION_INTERNA"))
    }


    /**
     * Construcción de un clase anónima
     */
    val listener = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("RECEIVER_TEL", "Llamada telefónica")
        }
    }


    /**
     * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            when (requestCode) {
                2 -> {}
            }
            super.onActivityResult(requestCode, resultCode, data)
        }
     ***/
}
