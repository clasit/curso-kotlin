package es.cta.android.parsearjson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import es.cta.android.parsearjson.R
import es.cta.android.parsearjson.users.User
import kotlinx.android.synthetic.main.item_user.view.*

class MainAdapter (private val ctx: Context, private val dataSource: List<User>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        var holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_user, parent, false)

            holder=ViewHolder()
            holder.tvNombre=view.tvNombre

            view.tag=holder
        }else{
            view=convertView
            holder=view.tag as ViewHolder
        }

        val user=dataSource.get(position)
        holder.tvNombre.text = user.name
        return view
    }

    override fun getItem(position: Int): Any {
        return dataSource.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    private class ViewHolder() {
        lateinit var tvNombre: TextView
    }
}