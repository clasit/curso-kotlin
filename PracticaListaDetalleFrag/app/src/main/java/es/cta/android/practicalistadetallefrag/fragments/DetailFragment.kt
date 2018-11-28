package es.cta.android.practicalistadetallefrag.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import es.cta.android.practicalistadetallefrag.R
import es.cta.android.practicalistadetallefrag.model.Hobby
import kotlinx.android.synthetic.main.fragment_detail.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val bundle = this.arguments
        view.tvTitleFD.text=bundle?.getString(Title)
        view.tvDescFD.text=bundle?.getString(Desc)
        return view
    }

    companion object {
        val Title: String = "TITLE"
        val Desc: String = "DESC"
        val Img: String = "IMG"

        fun newInstance(nombre: String, descripcion: String, img: String): DetailFragment {
            val args: Bundle = Bundle()
            args.putString(Title, nombre)
            args.putString(Desc, descripcion)
            args.putString(Img, img)
            val fragment = DetailFragment()
            fragment.arguments = args

            return fragment
        }
    }

}
