package top.stores.a20210509_pradeepgedara_nycschools.network

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity
import top.stores.a20210509_pradeepgedara_nycschools.repositories.Repository
import java.util.ArrayList

object VolleyNetworkManager {

    const val IMAGE_CONSTANT = "https://image.tmdb.org/t/p/w500/"



    fun downloadData(application: Application) {
        val PROJECT_URL = "https://data.cityofnewyork.us/resource/s3k6-pzi2.json"
        var schoolEntities: MutableList<SchoolsEntity> = ArrayList<SchoolsEntity>()



        val localJReq: JsonArrayRequest = object : JsonArrayRequest(PROJECT_URL,
            Response.Listener {

                try {
                    var schoolData: List<SchoolsEntity> = ArrayList()
                    val data = it
                    val gson = GsonBuilder().create()
                    val collectionType =
                        object : TypeToken<ArrayList<SchoolsEntity>>() {}.type


                    schoolData = gson.fromJson(
                        data.toString(),
                        collectionType
                    )
                    schoolEntities?.let { it1 ->
                        Repository.setSchoolList(
                            application,
                            it1
                        )
                    }

                    //  var repository: ProjectsRepository = ProjectsRepository(application)
                    // insert into the room database
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {
                Toast.makeText(
                    application.applicationContext,
                    "Sorry Something went wrong from our end when loading the projects!!",
                    Toast.LENGTH_LONG
                ).show()

            })
        {



        }
        VolleySingleton.getInstance(application.applicationContext).addToRequestQueue(localJReq)

    }

}