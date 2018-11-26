package es.cta.android.recetasandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import es.cta.android.recetasandroid.adapter.RecetaAdapter
import es.cta.android.recetasandroid.model.Receta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val recetas: ArrayList<Receta> = arrayListOf(
        Receta("Título 1", "Descripción 1", "https://qin.mx/img/platillos-kung-pao.png",
            "https://www.hogarmania.com/cocina/recetas/carnes/201811/chuleta-ternera-patatas-asadas-verduras-41587.html"),

        Receta("Título 2", "Descripción 2", "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_720/https://tucocinadomicilio.es/wp-content/uploads/2018/03/ensalada-de-pasta-web.png",
            "https://www.hogarmania.com/cocina/recetas/carnes/201811/chuleta-ternera-patatas-asadas-verduras-41587.html"),

        Receta("Título 3", "Descripción 3", "https://es.borges.es/wp-content/uploads/2014/06/empanadas-borges.png",
            "https://www.hogarmania.com/cocina/recetas/carnes/201811/chuleta-ternera-patatas-asadas-verduras-41587.html"),

        Receta("Título 4", "Descripción 4", "https://i0.wp.com/cuteandkids.com/wp-content/uploads/2016/05/Learnin-to-cook-with-Ferran_Adria-CUTEANDKIDS-plato-espaguetis.png",
            "https://www.hogarmania.com/cocina/recetas/carnes/201811/chuleta-ternera-patatas-asadas-verduras-41587.html")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstRecetas.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, InstruccionReceta::class.java)

            // Como es un data class podemos pasar el objeto entero
            // No es recomendable pasar objetos más pesados
            // Los objetos tienen que ser serializables
            // intent.putExtra("WebUrl", recetas.get(position).instruccion)

            val receta = recetas.get(position)
            intent.putExtra("receta", receta)
            startActivity(intent)
        }


        // Con 'as' se hace un casting a ArrayList<Receta>
        val adapter = RecetaAdapter(this, recetas)
        lstRecetas.adapter = adapter
    }
}
