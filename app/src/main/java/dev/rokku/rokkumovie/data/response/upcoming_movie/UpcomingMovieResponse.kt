package dev.rokku.rokkumovie.data.response.upcoming_movie


import com.google.gson.annotations.SerializedName

data class UpcomingMovieResponse(
    @SerializedName("dates")
    val dates: Dates? = Dates(),
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<UpcomingMovie> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)