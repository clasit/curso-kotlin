package es.cta.android.hobbies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import es.cta.android.hobbies.adapter.HobbieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /***
         * Tipos de RecyclerView: LinearLayoutManager, GridLayoutManager y StaggeredGridLayoutManager
         */
        lstViewHobbies.layoutManager = LinearLayoutManager(this)
        // lstViewHobbies.layoutManager= GridLayoutManager(this, 3)
        // lstViewHobbies.layoutManager= StaggeredGridLayoutManager(this)


        val adapter = HobbieAdapter(this, HobbiesProvider.getHobbies())
        lstViewHobbies.adapter = adapter
    }
}
