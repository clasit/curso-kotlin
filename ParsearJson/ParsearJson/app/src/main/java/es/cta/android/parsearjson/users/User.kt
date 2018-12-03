package es.cta.android.parsearjson.users

data class User(val id:Int, val name:String, val username:String, val email:String ){

    override fun toString(): String {
        return "nombre: ${name}, nombre usuario ${username}"
    }
}