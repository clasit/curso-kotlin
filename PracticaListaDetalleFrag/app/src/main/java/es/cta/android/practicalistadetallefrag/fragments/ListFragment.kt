package es.cta.android.practicalistadetallefrag.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.cta.android.practicalistadetallefrag.R
import es.cta.android.practicalistadetallefrag.adapter.HobbiesAdapter
import es.cta.android.practicalistadetallefrag.model.Hobby
import es.cta.android.practicalistadetallefrag.provider.HobbiesProvider
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import java.lang.ClassCastException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment() {
    var listener: Rellenable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)



        view?.rvListFr?.layoutManager = LinearLayoutManager(activity)

        view?.rvListFr?.adapter = HobbiesAdapter(activity, HobbiesProvider.getHobbies(), listener)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Rellenable) {
            listener = context as Rellenable
        } else {
            throw ClassCastException("Este contexto no es viable:${context.toString()}") as Throwable
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface Rellenable {

        fun rellenar(hobby: Hobby)

    }

}
