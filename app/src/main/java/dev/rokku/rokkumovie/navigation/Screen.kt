package dev.rokku.rokkumovie.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

@Serializable
object SearchGraph

@Serializable
object HomePage

@Serializable
object SearchPage

@Serializable
data class MovieDetailsPage(val id: Int, val mediaType: String)
