package dev.rokku.rokkumovie.data.response.top_rated_movie


import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<TopRatedMovie> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)