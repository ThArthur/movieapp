package dev.rokku.rokkumovie.data.response.trending_serie


import com.google.gson.annotations.SerializedName

data class TrendingSeriesResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<TrendingSerie> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)