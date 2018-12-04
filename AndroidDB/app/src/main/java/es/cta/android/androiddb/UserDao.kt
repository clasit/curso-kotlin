package es.cta.android.androiddb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import es.cta.android.androiddb.model.User

class UserDao(val ctx: Context) {

    lateinit var db: SQLiteDatabase
    var helper: DBHelper

    init {
        helper = DBHelper(ctx, "usersdb", 1)
    }

    fun open() {
        db = helper.writableDatabase
    }

    fun close() {
        helper.close()
    }

    fun createUser(user: User): Long {
        // ContentValues -> repositorio clave-valor
        val valores = ContentValues()
        valores.put(DBHelper.col_username, user.username)
        val res = db.insert(DBHelper.tablaUsers, null, valores)

        return res
    }

    fun deleteUser(user: User): Int {
        val res = db.delete(DBHelper.tablaUsers, "${DBHelper.col_id} == ?", arrayOf("${user.id}"))
        return res
    }

    fun getAllUsers(): List<User> {
        var items = ArrayList<User>()
        val cursor: Cursor = db.query(DBHelper.tablaUsers, arrayOf(DBHelper.col_id, DBHelper.col_username), null, null, null, null, null)

        cursor.moveToFirst()
        while (!cursor.isAfterLast){
            items.add( User( cursor.getInt(0), cursor.getString(1)))
            cursor.moveToNext()
        }

        return items
    }
}