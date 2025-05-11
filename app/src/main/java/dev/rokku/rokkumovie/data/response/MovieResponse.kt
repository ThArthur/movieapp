package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 49054
    @SerializedName("total_results")
    val totalResults: Int // 981065
)