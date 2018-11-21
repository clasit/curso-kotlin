package es.cta.android.holamundo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Toast.makeText(this, getParameter("nombre"), Toast.LENGTH_LONG).show()
    }

    fun getParameter(id: String): String {
        var nombre: String = ""
        val intent: Intent = getIntent()
        if ( intent.hasExtra(id) ) {
            nombre = intent.getStringExtra(id)
        }
        return nombre
    }
}
