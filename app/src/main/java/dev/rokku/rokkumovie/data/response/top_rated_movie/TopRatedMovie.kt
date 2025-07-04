package dev.rokku.rokkumovie.data.response.top_rated_movie


import com.google.gson.annotations.SerializedName
import dev.rokku.rokkumovie.presentation.data.model.MovieModel

data class TopRatedMovie(
    @SerializedName("adult")
    val adult: Boolean? = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int?>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("original_title")
    val originalTitle: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("video")
    val video: Boolean? = false,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0
) {
    fun toPopularMovieModel(): MovieModel {
        return MovieModel(
            id = id ?: 0,
            posterPath = posterPath ?: backdropPath,
            title = title ?: "",
            mediaType = "movie"
        )
    }
}