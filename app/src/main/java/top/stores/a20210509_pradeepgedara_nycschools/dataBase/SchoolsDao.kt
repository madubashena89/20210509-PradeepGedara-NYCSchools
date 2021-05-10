package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SchoolsDao {

    @Query("SELECT * FROM schools_table")
    fun getAllSchools() : List<SchoolsEntity>

    @Query("DELETE FROM schools_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setSchoolList(schoolsList: List<SchoolsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setSchool(schoolsList: SchoolsEntity)

    @Query("SELECT * FROM schools_table")
    fun getAllProjects(): List<SchoolsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setSchoolList(movieList: SchoolsEntity?)
}