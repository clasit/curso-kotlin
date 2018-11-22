package es.cta.android.listadotelefonico

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import es.cta.android.listadotelefonico.model.Telefono
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listin: List<Telefono> = listOf(
        Telefono("+34", "666333222"),
        Telefono("+34", "666111222"),
        Telefono("+34", "6660000222"),
        Telefono("+34", "677333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+34", "666333222"),
        Telefono("+33", "666555444"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstTelefonos.setOnItemClickListener { parent, view, position, id ->
            val tel: Telefono = listin.get(position)
            val numero = "${tel.prefijo}${tel.numero}"
            llamarPorTelefono(this, numero)
        }

        // Creamos un adaptador para poner la información en la lista
        // Se le pasa:
        // (1) El contexto (this)
        // (2) Como queremos pintar el dato, pasaremos un template predefinido de Android. El recurso prederinido se accede a traves de la palabra android
        // (3) Y los datos
        val adapter: ArrayAdapter<Telefono> = ArrayAdapter(this, android.R.layout.simple_list_item_1, listin)
        lstTelefonos.adapter = adapter
    }
}
