package es.cta.android.practicalistadetallefrag

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewCompat.getRotation
import android.util.Log
import es.cta.android.practicalistadetallefrag.fragments.DetailFragment
import es.cta.android.practicalistadetallefrag.fragments.ListFragment
import es.cta.android.practicalistadetallefrag.model.Hobby
import es.cta.android.practicalistadetallefrag.provider.HobbiesProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListFragment.Rellenable {

    lateinit var fraManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aux = savedInstanceState
        setContentView(R.layout.activity_main)
        val orientation = this.resources.configuration.orientation
        fraManager = supportFragmentManager

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) { //es vertical o portrait.

            val transaction: FragmentTransaction = fraManager.beginTransaction()
            transaction.add(R.id.fragmentList, ListFragment())
            transaction.commit()

            val hobbyInit = HobbiesProvider.getHobbies()[0]

            val transaction2: FragmentTransaction = fraManager.beginTransaction()
            transaction2.add(
                R.id.fragmentDetailLands,
                DetailFragment.newInstance(hobbyInit.nombre, hobbyInit.decripcion, "")
            )
            transaction2.commit()
        } else {
            val transaction: FragmentTransaction = fraManager.beginTransaction()
            transaction.add(R.id.fragmentlistP, ListFragment())
            transaction.commit()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("DEstroy", "DESTROY")
        val orientation = this.resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) { //es vertical o portrait.

            val transaction: FragmentTransaction = fraManager.beginTransaction()
            transaction.remove(fragmentList)
            transaction.commit()

            val transaction2: FragmentTransaction = fraManager.beginTransaction()
            transaction2.remove(fragmentDetailLands)
            transaction2.commit()
        } else {
            val transaction: FragmentTransaction = fraManager.beginTransaction()
            transaction.remove(fragmentlistP)
            transaction.commit()
        }
    }

    override fun rellenar(hobby: Hobby) {
        val transaction: FragmentTransaction = fraManager.beginTransaction()
        transaction.remove(fragmentDetailLands)
        transaction.add(R.id.fragmentDetailLands, DetailFragment.newInstance(hobby.nombre, hobby.decripcion, ""))
        transaction.commit()
    }
}
