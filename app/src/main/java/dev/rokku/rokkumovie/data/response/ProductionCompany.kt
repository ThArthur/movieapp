package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Int, // 127928
    @SerializedName("logo_path")
    val logoPath: String, // /h0rjX5vjW5r8yEnUBStFarjcLT4.png
    @SerializedName("name")
    val name: String, // 20th Century Studios
    @SerializedName("origin_country")
    val originCountry: String // US
)