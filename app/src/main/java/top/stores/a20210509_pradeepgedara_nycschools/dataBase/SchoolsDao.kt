package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SchoolsDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovies() : List<SchoolsEntity>

    @Query("DELETE FROM movie_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMoviesList(schoolsList: List<SchoolsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMovie(schoolsList: SchoolsEntity)
}