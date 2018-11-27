package es.cta.android.fragment01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.Toast

// Como usa Fragment_A se tiene que crear la función
class Main2Activity : AppCompatActivity(), Fragment_A.Enviable {

    override fun enviar(info: String) {
        Toast.makeText(this, info, Toast.LENGTH_LONG).show()
    }

    // Lo mejor es crear el fragment manager fuera del onCreate
    lateinit var fManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Cargamos un Fragment Manager para controlar los Fragmentos por código (En caliente)
        // Kotlin elimina el prefijo 'get'
        fManager = supportFragmentManager
        val transaccion: FragmentTransaction = fManager.beginTransaction()
        transaccion.add(R.id.container, Fragment_A())
        transaccion.commit()

        // OPERACIOENS TÍPICAS:-------------------------------------------------
        // transaccion.remove()
        // transaccion.replace()
        // transaccion.commit()
        //----------------------------------------------------------------------

        val transaccion2: FragmentTransaction = fManager.beginTransaction()
        transaccion2.add(R.id.container, Fragment_B.newInstance("Envia String a Fragment B"))
        transaccion2.commit()
    }
}
