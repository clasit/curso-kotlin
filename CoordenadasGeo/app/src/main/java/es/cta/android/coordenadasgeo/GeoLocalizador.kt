package es.cta.android.coordenadasgeo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.ArrayAdapter
import es.cta.android.coordenadasgeo.services.GeoService
import kotlinx.android.synthetic.main.geo_localizador.*

class GeoLocalizador : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<String>

    var posiciones: ArrayList<String> = ArrayList()
    var geoService: GeoService? = null
    var estaConectado: Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo_localizador)


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, posiciones)
        lstPosiciones.adapter = adapter



        btnPosiciones.setOnClickListener {
            val items = geoService?.obtenerPosiciones()  as ArrayList<Location>

            // Si items no es null, inserta el array a posiciones
            items?.let {
                Log.i("GPS:", it.toString())
                // posiciones.addAll(it.filter{it != null})
                posiciones.add("${it?.last().longitude} : ${it?.last().longitude}")
                adapter.notifyDataSetChanged()
            }
        }
    }



    override fun onResume() {
        super.onResume()

        // Binculación al servicio, lo mejor es desde la función 'onResume':
        if (!estaConectado) {
            // Creación de un intent explícito
            val i = Intent(this, GeoService::class.java)
            bindService(i, connex, Context.BIND_AUTO_CREATE)
        }
    }


    override fun onPause() {
        super.onPause()
        if (estaConectado) {
            unbindService(connex)
        }
    }


    private val connex = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            estaConectado = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as GeoService.GeoBinder
            geoService = binder.getService()
            estaConectado = true
        }

    }
}
