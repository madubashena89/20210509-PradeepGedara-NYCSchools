package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SchoolsEntity::class], version = 3)
abstract class AppDataBase : RoomDatabase(){
    abstract fun schoolDao(): SchoolsDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataseClient(context: Context) : AppDataBase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDataBase::class.java, "APP_DATABASE")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

                return INSTANCE!!

            }
        }

    }
}