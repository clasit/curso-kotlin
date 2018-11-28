package es.cta.android.practicalistadetallefrag.provider

import es.cta.android.practicalistadetallefrag.model.Hobby

object HobbiesProvider {
    fun getHobbies():ArrayList<Hobby>{
        return arrayListOf<Hobby>(
            Hobby("Hockey", " ", "Desc 1"),
            Hobby("Esqui", " ", "Desc 2"),
            Hobby("Tapeo", " ", "Desc 3"),
            Hobby("Cine", " ", "Desc 4")
        )
    }
}