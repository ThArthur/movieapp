package dev.rokku.rokkumovie.data.response.trending_movies


import com.google.gson.annotations.SerializedName
import dev.rokku.rokkumovie.presentation.data.model.MovieModel

data class TrendingMovie(
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("original_title")
    val originalTitle: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("media_type")
    val mediaType: String? = "",
    @SerializedName("adult")
    val adult: Boolean? = false,
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int?>? = listOf(),
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("video")
    val video: Boolean? = false,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("original_name")
    val originalName: String? = "",
    @SerializedName("first_air_date")
    val firstAirDate: String? = "",
    @SerializedName("origin_country")
    val originCountry: List<String?>? = listOf()
) {
    fun toMovieModel(): MovieModel {
        return MovieModel(
            id = id,
            posterPath = posterPath ?: backdropPath,
            title = title ?: name ?: originalName ?: "Title not found",
            mediaType = mediaType ?: ""
        )
    }
}