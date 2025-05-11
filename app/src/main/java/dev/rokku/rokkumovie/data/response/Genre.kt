package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int, // 878
    @SerializedName("name")
    val name: String // Science Fiction
)