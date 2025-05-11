package dev.rokku.rokkumovie.data.response.discover_movie


import com.google.gson.annotations.SerializedName

data class DiscoverMovieResponse(
    @SerializedName("page")
    val page: Int? = 0, // 1
    @SerializedName("results")
    val results: List<DiscoverMovie> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)