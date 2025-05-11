package dev.rokku.rokkumovie.presentation.ui.screens.home

import dev.rokku.rokkumovie.presentation.data.model.MovieModel

data class HomeMoviesState(
    val popularMovies: List<MovieModel> = emptyList(),
    val discoverMovies: List<MovieModel> = emptyList(),
    val discoverTv: List<MovieModel> = emptyList(),
    val topRatedMovies: List<MovieModel> = emptyList(),
    val airingTodaySerie: List<MovieModel> = emptyList(),
    val onTheAirSeries: List<MovieModel> = emptyList(),
    val dayTrendingMovies: List<MovieModel> = emptyList(),
    val weekTrendingMovies: List<MovieModel> = emptyList(),
    val dayTrendingSerie: List<MovieModel> = emptyList(),
    val weekTrendingSerie: List<MovieModel> = emptyList(),
    val upcomingMovies: List<MovieModel> = emptyList(),
    val loading: Boolean = false
)