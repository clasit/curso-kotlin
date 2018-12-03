package es.cta.android.coordenadasgeo.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Binder
import android.os.Bundle
import android.os.IBinder

class GeoService : Service() {

    private val posiciones: ArrayList<Location?> = ArrayList()
    private val geobinder: GeoBinder = GeoBinder()

    // Manager para controlar los sensores
    private lateinit var locManager: LocationManager

    // Escucha de los eventos de localización
    private lateinit var locListener: LocationListener



    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()
        // Daremos de alta la escucha activa
        locListener = object : LocationListener {
            override fun onProviderDisabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onProviderEnabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onLocationChanged(location: Location?) {
                posiciones.add(location)
            }
        }

        locManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locListener)
    }


    // API PUBLICA
    fun obtenerPosiciones(): ArrayList<Location?> {
        return posiciones
    }


    // Al ser un servicio binculado, se tiene que develver un IBinder en el onBind
    override fun onBind(intent: Intent): IBinder {
        return geobinder
    }


    inner class GeoBinder: Binder() {
        fun getService(): GeoService {

            // Devuelve una instancia de la clase GeoService
            return this@GeoService
        }
    }
}
