package es.cta.android.fragment01


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment_A : Fragment() {


    // Se define una interfaz interna
    interface Enviable {
        fun enviar(info: String)
    }

    // Se hace una variable de tipo de la interfaz
    var listener: Enviable? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_a, container, false)

        val buttonA: Button = view?.button_a
        // ALTERNATIVA para acceder a un Widget:
        // val buttonA: Button = view?.findViewById(R.id.button_a) as Button

        buttonA.setOnClickListener {

            // En Fragment lanza un evento "enviar"
            listener?.enviar("Saludos desde Fragment A")

            // ALTERNATIVA
            // Toast.makeText(it.context, "Hola!!", Toast.LENGTH_LONG).show()
            // Toast.makeText(inflater.context, "Hola!!", Toast.LENGTH_LONG).show()
            // Toast.makeText(activity, "Hola!!", Toast.LENGTH_LONG).show()
        }

        // Inflate the layout for this fragment
        return view
    }



    override fun onAttach(context: Context?) {
        // Un Frament que recibe el context, el context es la propia Activity
        super.onAttach(context)
        if( context is Enviable ) {
            listener = context
        }
        else {
            throw ClassCastException("El contexto no es enviable")
        }
    }


    // Al quitar el Frament se tiene que inicializar a 'null'
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
