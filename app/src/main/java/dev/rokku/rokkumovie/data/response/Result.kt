package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName
import dev.rokku.rokkumovie.presentation.data.model.MovieModel

data class Result(
    @SerializedName("adult")
    val adult: Boolean?, // false
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /9nhjGaFLKtddDPtPaX5EmKqsWdH.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("id")
    val id: Int, // 950396
    @SerializedName("original_language")
    val originalLanguage: String?, // en
    @SerializedName("original_title")
    val originalTitle: String?, // The Gorge
    @SerializedName("overview")
    val overview: String?, // Two highly trained operatives grow close from a distance after being sent to guard opposite sides of a mysterious gorge. When an evil below emerges, they must work together to survive what lies within.
    @SerializedName("popularity")
    val popularity: Double?, // 974.107
    @SerializedName("poster_path")
    val posterPath: String?, // /7iMBZzVZtG0oBug4TfqDb9ZxAOa.jpg
    @SerializedName("release_date")
    val releaseDate: String?, // 2025-02-13
    @SerializedName("title")
    val title: String, // The Gorge
    @SerializedName("video")
    val video: Boolean?, // false
    @SerializedName("vote_average")
    val voteAverage: Double?, // 7.767
    @SerializedName("vote_count")
    val voteCount: Int? // 1700
) {
    fun toMovieModel(): MovieModel {
        return MovieModel(
            id = id,
            posterPath = posterPath,
            title = title,
            mediaType = "movie"
        )
    }
}