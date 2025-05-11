package dev.rokku.rokkumovie.data.response.serie


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo_path")
    val logoPath: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("origin_country")
    val originCountry: String? = ""
)