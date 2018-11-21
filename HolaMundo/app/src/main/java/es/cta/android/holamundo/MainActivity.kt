package es.cta.android.holamundo

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_b.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_b)

        // tvSaludo.text = "Holaaaa!"
    }

    fun verMensaje(v: View) {
        Log.i("ACTIVITY_B", "Botón pulsado")

        // Toast es un elemento estático: se puede usar sin instanciarlo
        Toast.makeText(this, "Saludos", Toast.LENGTH_LONG).show()
    }

    /* fun goActivity2(v: View) {
        Log.i("ACTIVITY_B", "goActivity2")

        // INTENT
        // Primer parámetro es el origen (this)
        // Segundo parámetro es le destino ( Main2Activity::class.java)
        var intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("mensaje", "Saludos desde la otra pantalla")

        // Lanzar el intent
        startActivity(intent)

        // NOTA: El botón "Back" provoca el "finish", elimina la Activity
    } */

    fun enviarNombre(v: View) {

        // Text no devuelve un String, sino un "EditableText"
        var nombre: String = etNombre.text.toString()
        var intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("nombre", nombre)
        startActivity(intent)
    }

    fun goActivity2() {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.data = Uri.parse("tel:999")
        startActivity(intent)
    }
}
