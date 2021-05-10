package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "movie_table", primaryKeys = ["id"])
class SchoolsEntity {

    @NotNull
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var movieID : String? = null

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title : String? = null

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    var releaseDate : String? = null

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    var voteAverage : Double = 0.0

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    var posterPath : String? = null

    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    var backdropPath : String? = null

    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    var overview : String? = null

//    @Ignore
//    constructor(
//        movieID: String?,
//        title: String?,
//        releaseDate: String?,
//        voteAverage: Double,
//        posterPath: String?,
//        backdropPath: String?,
//        overview: String?
//    ) {
//        this.movieID = movieID
//        this.title = title
//        this.releaseDate = releaseDate
//        this.voteAverage = voteAverage
//        this.posterPath = posterPath
//        this.backdropPath = backdropPath
//        this.overview = overview
//    }

    constructor()
}