package top.stores.a20210509_pradeepgedara_nycschools.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.AppDataBase
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity

class Repository  {


    companion object{

        var appDatabase: AppDataBase? = null

        var schoolList: List<SchoolsEntity>? = null


        fun initializeDB(context: Context): AppDataBase {
            return AppDataBase.getDataseClient(context)
        }

        fun setSchoolList(context: Context, schoollist: List<SchoolsEntity>) {

            appDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                schoollist.forEach {
                    //  it.type=type
                    appDatabase!!.schoolDao().setSchoolList(it)

                }
            }

        }

        fun getSchools(context: Context): List<SchoolsEntity> {
            appDatabase = initializeDB(context)

            schoolList = appDatabase!!.schoolDao().getAllProjects()

            return schoolList as List<SchoolsEntity>
        }
}

}