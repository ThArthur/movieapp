package dev.rokku.rokkumovie.data.response.on_the_air


import com.google.gson.annotations.SerializedName

data class OnTheAirSeriesResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<OnTheAir> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)