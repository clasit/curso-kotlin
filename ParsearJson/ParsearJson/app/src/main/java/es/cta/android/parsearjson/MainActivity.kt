package es.cta.android.parsearjson

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import es.cta.android.parsearjson.adapter.ImgAdapter
import es.cta.android.parsearjson.adapter.MainAdapter
import es.cta.android.parsearjson.asyncTasks.ImgAsynTask
import es.cta.android.parsearjson.asyncTasks.MainAsyncTask
import es.cta.android.parsearjson.users.Image
import es.cta.android.parsearjson.users.User
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val UserTask = object : MainAsyncTask(this) {
            override fun onPostExecute(result: List<User>) {

                super.onPostExecute(result)
                val adapter=MainAdapter(ctx, result)
                lvUsers.adapter=adapter
            }
        }.execute("https://jsonplaceholder.typicode.com/users")*/

        val ImgTask=object :ImgAsynTask(this){
            override fun onPostExecute(result: List<Image>) {
                super.onPostExecute(result)
                val adapter=ImgAdapter(ctx, result)
                lvUsers.adapter=adapter

                lvUsers.setOnItemClickListener { parent, view, position, id ->
                    val data = result?.get(position)
                    File(Environment.getExternalStorageDirectory(), "user").writeText("Titulo: ${data?.title}")
                }
            }
        }.execute("https://jsonplaceholder.typicode.com/photos")

        //MainAsyncTask2(this).execute("https://jsonplaceholder.typicode.com/users")
    }


}
