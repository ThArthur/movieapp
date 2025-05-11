package dev.rokku.rokkumovie.data.response.airing_today_serie


import com.google.gson.annotations.SerializedName

data class AiringTodaySerieResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<AiringToday> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)