package dev.rokku.rokkumovie.presentation.data.model

import dev.rokku.rokkumovie.data.response.Genre


data class MediaDetail(
    val id: Int,
    val overview: String,
    val backdropPath: String,
    val title: String,
    val runtime: String,
    val voteAverage: Double,
    val genres: List<Genre>,
)
