package dev.rokku.rokkumovie.data.response.serie


import com.google.gson.annotations.SerializedName

data class CreatedBy(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("credit_id")
    val creditId: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("original_name")
    val originalName: String? = "",
    @SerializedName("gender")
    val gender: Int? = 0,
    @SerializedName("profile_path")
    val profilePath: String? = ""
)