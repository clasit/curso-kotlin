package es.cta.android.practicalistadetallefrag.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.cta.android.practicalistadetallefrag.Main2Activity
import es.cta.android.practicalistadetallefrag.R
import es.cta.android.practicalistadetallefrag.fragments.DetailFragment
import es.cta.android.practicalistadetallefrag.fragments.ListFragment
import es.cta.android.practicalistadetallefrag.model.Hobby
import kotlinx.android.synthetic.main.hobby_item.view.*

class HobbiesAdapter(val ctx: Context?, val hobbies: ArrayList<Hobby>, val listener:ListFragment.Rellenable?) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.hobby_item, p0, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val hobby = hobbies[p1]

        p0.setData(hobby, p1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       lateinit var hobby: Hobby
        var pos: Int = 0

        init {
            itemView.btnToDetail.setOnClickListener {

                val orientation = ctx?.resources?.configuration?.orientation

                if (orientation == Configuration.ORIENTATION_LANDSCAPE) { //es vertical o portrait.
                        listener?.rellenar(hobby)
                } else {
                    val intent = Intent(ctx, Main2Activity::class.java)
                    intent.putExtra("Title", hobby.nombre)
                    intent.putExtra("Desc", hobby.decripcion)
                    intent.putExtra("Img", hobby.img)
                    ctx?.startActivity(intent)
                }

            }
        }

        fun setData(h: Hobby, pos:Int) {
            itemView.tvTitle.text = h.nombre
            this.hobby=h
            this.pos=pos
        }


    }
}