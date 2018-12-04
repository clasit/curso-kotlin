package es.cta.android.androiddb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(val ctx: Context, var dbname: String, val version: Int) :
    SQLiteOpenHelper(ctx, dbname, null, version) {

    // onCreate sólo se ejecuta 1 vez. La primera vez que se lanza la Aplicación.
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(script_inicial)
    }

    // onUpgrade se ejecuta cuando hay un cambio de versión de la base de datos, se detecta automáticamente,
    // por la metatada de la base de datos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exist ${tablaUsers}")
        onCreate(db)
    }

    // Parte estática de la clase
    companion object {
        val tablaUsers: String = "users"
        var col_id = "_id"
        val col_username = "username"
    }

    val script_inicial = "create table ${tablaUsers} " +
                            "(${col_id} integer primary key autoincrement" +
                            ",${col_username} text not null);"
}