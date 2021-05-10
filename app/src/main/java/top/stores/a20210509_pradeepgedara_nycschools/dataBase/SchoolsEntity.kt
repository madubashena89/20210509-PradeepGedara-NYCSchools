package top.stores.a20210509_pradeepgedara_nycschools.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "movie_table", primaryKeys = ["id"])
class SchoolsEntity {

    @NotNull
    @SerializedName("dbn")
    @ColumnInfo(name = "dbn")
    var schoolID : String? = null

    @SerializedName("school_name")
    @ColumnInfo(name = "school_name")
    var schoolName : String? = null

    @SerializedName("phone_number")
    @ColumnInfo(name = "phone_number")
    var phoneNumber : String? = null

    @SerializedName("school_email")
    @ColumnInfo(name = "school_email")
    var email : Double = 0.0

    @SerializedName("website")
    @ColumnInfo(name = "website")
    var schoolWebsite : String? = null

    @SerializedName("city")
    @ColumnInfo(name = "city")
    var city : String? = null

    @SerializedName("overview_paragraph")
    @ColumnInfo(name = "overview_paragraph")
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