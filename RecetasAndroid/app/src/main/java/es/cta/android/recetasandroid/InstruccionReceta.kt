package es.cta.android.recetasandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import es.cta.android.recetasandroid.model.Receta
import kotlinx.android.synthetic.main.activity_instruccion_receta.*

class InstruccionReceta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruccion_receta)

        val intent = getIntent()
        val receta: Receta = intent.getParcelableExtra<Receta>("receta")

        wvReceta.settings.javaScriptEnabled = true

        wvReceta.webViewClient = RecetaWebClient()

        wvReceta.loadUrl(receta.instruccion)
    }


    private class RecetaWebClient: WebViewClient() {

        // NOTA: Se extiende de WebViewClient y se sobrescribe para evitar que se abra el navegador del sistema, que en algunos casos de puede
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return false
        }
    }
}
