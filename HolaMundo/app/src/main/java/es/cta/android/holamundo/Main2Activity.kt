package es.cta.android.holamundo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Toast.makeText(this, getParameter("nombre"), Toast.LENGTH_LONG).show()

        btnClose.setOnClickListener {
            finish()
        }
    }

    fun getParameter(id: String): String {
        var nombre: String = ""
        val intent: Intent = getIntent()
        if ( intent.hasExtra(id) ) {
            nombre = intent.getStringExtra(id)
        }
        return nombre
    }

    override fun onDestroy() {
        Log.i("ACTIVITY 2", "Destrucción de la actividad")
        super.onDestroy()
    }

    override fun onPause() {
        Log.i("ACTIVITY 2", "Pause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("ACTIVITY 2", "Stop")
        super.onStop()
    }
}
