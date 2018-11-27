package es.cta.android.fragment01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

// Implementa la Interfaz del Fragment A. Así el 'context' es de tipo Enviable
class MainActivity : AppCompatActivity(), Fragment_A.Enviable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // El Fragment es como un Emisor de eventos
    override fun enviar(info: String) {
        // El this es la actividad (el context)
        Toast.makeText(this, info, Toast.LENGTH_LONG).show()
    }
}
