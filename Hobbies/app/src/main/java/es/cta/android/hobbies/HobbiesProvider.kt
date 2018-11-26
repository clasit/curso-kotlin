package es.cta.android.hobbies

import es.cta.android.hobbies.model.Hobbie


/**
 * Ejemplo de uso de un Singleton. Ya está instanciado.
 */
object HobbiesProvider {

    fun getHobbies(): ArrayList<Hobbie> {
        return arrayListOf(
            Hobbie("Deporte", ""),
            Hobbie("Musica", ""),
            Hobbie("Idiomas", ""),
            Hobbie("Viajar", "")
        )
    }
}
