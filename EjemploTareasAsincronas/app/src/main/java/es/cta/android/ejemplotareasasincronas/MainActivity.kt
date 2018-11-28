package es.cta.android.ejemplotareasasincronas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import es.cta.android.ejemplotareasasincronas.services.MyService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLaunchAction.setOnClickListener {
            Intent(this, MyService::class.java).also {
                    intent ->
                        intent.putExtra("url", "https://developer.android.com")
                        startService(intent)
            }
        }
    }


    /**
     * Construcción de un clase anónima
     */
    val listener = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val dato = intent?.getStringExtra("RESULT")
            Log.i("MY_APP", dato)
        }
    }


    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(listener, IntentFilter("ACCION_INTERNA"))
    }


    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(listener)
    }
}
