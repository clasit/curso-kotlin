package es.cta.android.androiddb.model

data class User(var id:Int, var username: String) {
    override fun toString(): String {
        return username
    }
}