package es.cta.android.boundedservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import es.cta.android.boundedservice.services.ServiceBounded
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAction.setOnClickListener {
            Toast.makeText(this, myService?.getData(), Toast.LENGTH_LONG).show()
        }
    }


    override fun onResume() {
        super.onResume()
        Intent(this, ServiceBounded::class.java).also {
                intent -> bindService(intent, connextion, Context.BIND_AUTO_CREATE)
        }
    }


    var myService: ServiceBounded? = null
    var vinculado: Boolean = false

    val connextion = object : ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            vinculado = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            vinculado = true
            val binder = service as ServiceBounded.MyBinder
            myService = binder.getServicd()
        }

    }
}
