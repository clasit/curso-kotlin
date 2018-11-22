package es.cta.android.listadotelefonico

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat


fun llamarPorTelefono(ctx:Context, numero: String) {

    // Comprueba que tenga los permisos
    if( ActivityCompat.checkSelfPermission(ctx, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED ) {
        val intent: Intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:${numero}")

        // Cuando no está dentro de una Activity se tiene que pasar el "Context"
        ctx.startActivity(intent)
    } else {
        // Se avisaría al usuario que se necesita acceso al CALL_PHONE
    }
}