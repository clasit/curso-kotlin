package es.cta.android.parsearjson.asyncTasks

import android.content.Context
import android.os.AsyncTask
import com.google.gson.Gson
import es.cta.android.parsearjson.users.Image
import es.cta.android.parsearjson.users.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

open class ImgAsynTask (val ctx: Context) : AsyncTask<String, Unit, List<Image>>() {


    override fun doInBackground(vararg params: String?): List<Image> {
        val client: OkHttpClient = OkHttpClient()
        val request: Request = Request.Builder().url(params[0]).build()
        val response: Response = client.newCall(request).execute()
        val body= response.body()!!.string()

        val res = Gson().fromJson(body, Array<Image>::class.java).toList()

        return res
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onPostExecute(result: List<Image>) {
        super.onPostExecute(result)
    }

    override fun onProgressUpdate(vararg values: Unit?) {
        super.onProgressUpdate(*values)
    }
}