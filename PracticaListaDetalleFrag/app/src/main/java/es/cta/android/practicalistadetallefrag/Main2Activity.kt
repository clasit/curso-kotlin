package es.cta.android.practicalistadetallefrag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import es.cta.android.practicalistadetallefrag.fragments.DetailFragment

class Main2Activity : AppCompatActivity() {
    lateinit var fraManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fraManager = supportFragmentManager

        val intent = getIntent()
        val transaction: FragmentTransaction = fraManager.beginTransaction()
        transaction.add(
            R.id.fragmentDetailAct2, DetailFragment.newInstance(
                intent.getStringExtra("Title"),
                intent.getStringExtra("Desc"),
                intent.getStringExtra("Img")
            )
        )

        transaction.commit()
    }
}
