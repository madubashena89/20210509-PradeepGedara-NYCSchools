package top.stores.a20210509_pradeepgedara_nycschools.network

import android.app.Application
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity
import top.stores.a20210509_pradeepgedara_nycschools.repositories.Repository
import java.util.ArrayList

object VolleyNetworkManager {

    const val IMAGE_CONSTANT = "https://image.tmdb.org/t/p/w500/"
    // private val movieRepository = MovieRepository()

    fun downloadData(application: Application){
        val url: String = "https://api.themoviedb.org/4/list/1?page=1&api_key=d956f280a7d5133bcf5ca8233b99febf"
        val movieEntities: MutableList<SchoolsEntity> = ArrayList<SchoolsEntity>()


// get the json object
        val objectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
                { response ->
                    try {
                        val movieList = response.getJSONArray("results")
                        for (i in 0 until movieList.length()) {
                            val newMovie = SchoolsEntity()
                            val detailsOfMovieFromApi = movieList[i] as JSONObject
                            val gson = Gson()
                            val entity : SchoolsEntity = gson.fromJson(detailsOfMovieFromApi.toString(), SchoolsEntity::class.java)
                            Log.d("EntityValues", "$entity")
                            movieEntities.add(entity)
                        }
                        var repository : Repository = Repository(application)
                        repository.setMoviesList(movieEntities) // insert into the room database
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                },
                { error ->
                    error.printStackTrace() })
        VolleySingleton.getInstance(application.applicationContext).addToRequestQueue(objectRequest)
    }

}