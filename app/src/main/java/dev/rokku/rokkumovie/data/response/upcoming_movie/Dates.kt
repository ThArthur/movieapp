package dev.rokku.rokkumovie.data.response.upcoming_movie


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String? = "",
    @SerializedName("minimum")
    val minimum: String? = ""
)