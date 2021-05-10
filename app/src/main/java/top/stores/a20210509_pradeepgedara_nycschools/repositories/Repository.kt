package top.stores.a20210509_pradeepgedara_nycschools.repositories

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.AppDataBase
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsDao
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity
import top.stores.a20210509_pradeepgedara_nycschools.network.VolleyNetworkManager
import kotlin.coroutines.CoroutineContext

class Repository (application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val schoolsDao : SchoolsDao?

    init {
        val db = AppDataBase.getDatabase(application)
        schoolsDao = db?.movieDao()
        VolleyNetworkManager.downloadData(application)
    }

    fun getSchools() = schoolsDao?.getAllMovies()

    fun getMoviesList() = schoolsDao?.getAllMovies()


    fun setSchoolsList(movieslist: List<SchoolsEntity>) {
        launch  { movieslist.forEach{
            setMessageBG(it)
        } }
    }

    private suspend fun setMessageBG(schools: SchoolsEntity){
        withContext(Dispatchers.IO){
            schoolsDao?.setMovie(schools)
        }
    }

//    fun downloadMovieData(){
//        VolleyNetworkManager.downloadData(this)
//
//    }

}