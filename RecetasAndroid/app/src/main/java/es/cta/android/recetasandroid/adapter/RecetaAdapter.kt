package es.cta.android.recetasandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import es.cta.android.recetasandroid.R
import es.cta.android.recetasandroid.model.Receta
import kotlinx.android.synthetic.main.item_receta.view.*

class RecetaAdapter(private val ctx: Context, private val data: ArrayList<Receta>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        var holder: ViewHolder

        // Se crea por primera vez el holder
        if ( convertView == null ) {
            // Layout inflater ayuda a cargar en memoria los templates
            // Con inflate() decimos como pintar
            view = LayoutInflater.from(ctx).inflate(R.layout.item_receta, parent, false)
            holder = ViewHolder()
            holder.tvTitulo = view.tvTitle
            holder.tvDesc = view.tvDescription
            holder.image = view.ivReceta

            // El 'tag' es como una especie de "cajón de sastre"
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        var receta = data.get(position)
        holder.tvTitulo.text = receta.titulo
        holder.tvDesc.text = receta.desc
        Glide.with(view).load(receta.imgThumb).into(holder.image)

        // view.tvTitle.text = data.get(position).titulo
        // view.tvDescription.text = data.get(position).desc
        // Glide.with(view).load(data.get(position).imgThumb).into(view.ivReceta)

        return view
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }


    // ViewHolder: Contendrá cada uno de los Widgets
    private class ViewHolder {

        // lateinit -> Indica que se inicializará después

        lateinit var tvTitulo: TextView
        lateinit var tvDesc: TextView
        lateinit var image: ImageView
    }
}