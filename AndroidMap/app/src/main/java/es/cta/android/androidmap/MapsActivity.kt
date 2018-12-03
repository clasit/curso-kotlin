package es.cta.android.androidmap

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val storedLocation = ArrayList<LatLng>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setupGPS()
    }



    /**
     * SETUP GPS
     *
     * <uses-feature android:name="android.hardware.location.gps"></uses-feature>
     */
    // Manager para controlar los sensores
    private lateinit var locManager: LocationManager

    // Escucha de los eventos de localización
    private lateinit var locListener: LocationListener

    private fun setupGPS() {
        /**
         * Pedir permisos
         */
        // (1) Mira si tiene el permiso en el manifest
        var permissonCheck = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissonCheck != PackageManager.PERMISSION_GRANTED) {
            // (2) Si no está definido, se fuerza el pop-up del usuario
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            locManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

            // Daremos de alta la escucha activa
            locListener = object : LocationListener {
                override fun onProviderDisabled(provider: String?) {}
                override fun onProviderEnabled(provider: String?) {}
                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
                override fun onLocationChanged(location: Location?) {
                    location?.let {
                        placeMarkerOnMap(it)
                    }
                }
            }
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0f, locListener)
        }
    }

    private fun placeMarkerOnMap(location: Location) {
        val currentLocation = LatLng(location?.latitude, location?.longitude)
        val markerOptions = MarkerOptions().position(currentLocation)
        val address = getAdress(currentLocation)
        markerOptions.title(address)
        storedLocation.add(currentLocation)
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupGPS()
            } else {
                Toast.makeText(this, "No se podrá actualizar su posición", Toast.LENGTH_LONG).show()
            }
        }
    }



    /**
     * ON MAP READY
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        // Pone una posición guardada en el mapa
        restoreData()
    }


    private fun getAdress(latLng: LatLng): String {
        val geocoder = Geocoder(this)
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            if (addresses != null && !addresses.isEmpty()) {
                address = addresses.get(0)
                for(i in 0 .. address.maxAddressLineIndex){
                    addressText += if(i == 0) address.getAddressLine(i) else "\n${address.getAddressLine(i)}"
                }
            }
        } catch (e: IOException) {
            Log.e("GEOCODER", "ERROR")
        }

        return addressText
    }



    /**
     * Persist data in file
     */

    private fun serializar(locations: ArrayList<LatLng>): String {
        return Gson().toJson(locations)
    }

    private fun persistirDatosLocalizacion() {

        /**
         * Guarda en el "SharedPreferences"
         */
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString("positions", serializar(storedLocation))
        editor.apply()
        // 'apply()' es asincrono y 'commit()' es sincrono
        // editor.commit()

        /**
         * Se puede usar "getSharedPreferences" para que cualquier Actividad de la App pueda leer los datos
         * Sin embargo "getPreferences(Context.MODE_PRIVATE)" sólo podrá acceder (leer y escribir) la
         * Actividad que crea el archivo.
         **/


        /**
         * Guarda en el sistema de ficheros (puede ser interno o externo)
         */
        val fos: FileOutputStream = openFileOutput("positions", Context.MODE_PRIVATE)
        fos.write(serializar(storedLocation).toByteArray())
        fos.close()
    }

    override fun onStop() {
        super.onStop()
        persistirDatosLocalizacion()
    }


    /**
     * Restore Data from SharedPreferences
     */
    private fun restoreData() {
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val data: String = prefs.getString("positions", "")
        val posiciones = Gson().fromJson(data, Array<Location>::class.java)

        if( posiciones != null && !posiciones.isEmpty() && posiciones.get(0) !== null ) {
            placeMarkerOnMap(posiciones.get(0))
        }


        /**
         * Recupera los datos del sistema de ficheros (puede ser interno o externo)
         */
        /* val fis: FileInputStream = openFileInput("positions")
        val obj = ObjectInputStream(fis)
        val data2: ArrayList<LatLng> = obj.readObject() as ArrayList<LatLng>
        Log.i("_MAP", data2.toString()) */
    }
}
