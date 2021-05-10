package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SchoolsEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase(){
    abstract fun movieDao(): SchoolsDao


    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java, "schools_database").allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}