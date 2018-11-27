package es.cta.android.fragment01


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_b.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment_B : Fragment() {


    // Patrón factory de tipos "Fragment_A"
    // Hacemos una parte estática dentro de un clase
    companion object {
        var CLAVE: String = "DATA"

        fun newInstance(info: String): Fragment_B {
            val args: Bundle = Bundle()
            args.putString(CLAVE, info)

            val fragment = Fragment_B()
            fragment.arguments = args       // Paso de parámetros mediante un Patrón Factory

            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_b, container, false)
        val bundle = this.arguments
        view.tvMenssage.text = bundle?.getString(Fragment_B.CLAVE)

        // Inflate the layout for this fragment
        return view
    }


}
