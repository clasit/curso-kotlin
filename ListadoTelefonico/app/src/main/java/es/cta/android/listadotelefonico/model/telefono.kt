package es.cta.android.listadotelefonico.model

data class Telefono(val prefijo:String, val numero:String) {

    // Se sobrecarga el método toString
    // Ejercicio: Custom List... Mostrar lo prefijos de otro color
    override fun toString(): String {
        return "(${prefijo}) -  ${numero}"
    }
}