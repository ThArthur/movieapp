package dev.rokku.rokkumovie.data.response.discover_tv


import com.google.gson.annotations.SerializedName

data class DiscoverTvResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<DiscoverTv> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)