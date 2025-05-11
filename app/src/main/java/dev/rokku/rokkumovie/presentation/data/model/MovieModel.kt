package dev.rokku.rokkumovie.presentation.data.model

data class MovieModel(
    val id: Int,
    val posterPath: String? = "",
    val title: String,
    val mediaType: String
)
