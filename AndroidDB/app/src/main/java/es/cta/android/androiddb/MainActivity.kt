package es.cta.android.androiddb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import es.cta.android.androiddb.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var usersCount: Int = 0
    lateinit var usersSource: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersSource = UserDao(this)
        usersSource.open()

        val users: List<User> = usersSource.getAllUsers()

        val adapter: ArrayAdapter<User> = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        lstUsers.adapter = adapter

        lstUsers.setOnItemClickListener { _, _, position, _ ->
            val u = users.get(position)
            val res = usersSource.deleteUser(u)
            Log.i("_DB", res.toString())
            adapter.remove(u)
            adapter.notifyDataSetChanged()
        }

        btnGetUsers.setOnClickListener {
            var u = User(usersCount, "Usuario ${usersCount}")
            usersSource.createUser(u)
            adapter.add(u)
            adapter.notifyDataSetChanged()
        }
    }


    override fun onStop() {
        super.onStop()
        usersSource.close()
    }
}
