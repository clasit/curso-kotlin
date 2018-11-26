package es.cta.android.hobbies.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.cta.android.hobbies.R
import es.cta.android.hobbies.model.Hobbie
import kotlinx.android.synthetic.main.item_hobbie.view.*

class HobbieAdapter(
    private val ctx: Context,
    private var data: ArrayList<Hobbie>
) : RecyclerView.Adapter<HobbieAdapter.HobbieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HobbieViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_hobbie, parent, false)
        return HobbieViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HobbieViewHolder, position: Int) {
        val hobbie = data[position]
        holder.setData(hobbie, position)
    }

    inner class HobbieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var hobbie: Hobbie? = null

        // NOTA: El bloque 'init' se ejecuta antes que el constructor
        init {
            itemView.buttoShare.setOnClickListener {

                // El itemView es la entidad que contiene los Widgets
                // val infoHobbie = itemView.titleHobbie.text

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Me gusta: ${hobbie?.title}")

                // startActivity() se tiene que ejecutar a través de un contesto, puesto que no hereda de AppCompatActivity
                ctx.startActivity(Intent.createChooser(intent, "Compartir..."))
            }
        }

        fun setData(h: Hobbie?, positon: Int) {
            itemView.titleHobbie.text = h!!.title
            this.hobbie = h
            // itemView.imageHobbie. = h!!.image
        }
    }
}