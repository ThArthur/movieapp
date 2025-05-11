package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName

data class BelongsToCollection(
    @SerializedName("id")
    val id: Int, // 87096
    @SerializedName("name")
    val name: String, // Avatar Collection
    @SerializedName("poster_path")
    val posterPath: String, // /3C5brXxnBxfkeKWwA1Fh4xvy4wr.jpg
    @SerializedName("backdrop_path")
    val backdropPath: String // /gxnvX9kF7RRUQYvB52dMLPgeJkt.jpg
)