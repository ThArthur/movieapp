package dev.rokku.rokkumovie.data.response.discover_tv


import com.google.gson.annotations.SerializedName
import dev.rokku.rokkumovie.presentation.data.model.MovieModel

data class DiscoverTv(
    @SerializedName("adult")
    val adult: Boolean? = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int?>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("origin_country")
    val originCountry: List<String?>? = listOf(),
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("first_air_date")
    val firstAirDate: String? = "",
    @SerializedName("name")
    val name: String?,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0
) {
    fun toMovieModel(): MovieModel {
        return MovieModel(
            id = id ?: 0,
            posterPath = posterPath ?: backdropPath,
            title = name ?: originalName ?: "Title not found",
            mediaType = "tv"
        )
    }
}