package es.cta.android.parsearjson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import es.cta.android.parsearjson.R
import es.cta.android.parsearjson.users.Image
import es.cta.android.parsearjson.users.User
import kotlinx.android.synthetic.main.item_user.view.*

open class ImgAdapter(private val ctx: Context, private val dataSource: List<Image>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        var holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_user, parent, false)

            holder = ViewHolder()
            holder.tvNombre = view.tvNombre
            holder.ivImage = view.ivImage
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val img = dataSource.get(position)
        holder.tvNombre.text = img.title
        Glide.with(holder.ivImage).load(img.thumbnailUrl).into(holder.ivImage)
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
        lateinit var ivImage: ImageView
    }
}