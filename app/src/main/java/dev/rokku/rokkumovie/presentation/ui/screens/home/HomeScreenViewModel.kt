package dev.rokku.rokkumovie.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rokku.rokkumovie.data.TmdbRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val tmdbRepository: TmdbRepository
) : ViewModel() {

    private val _moviesState = MutableStateFlow(HomeMoviesState())
    val moviesState: StateFlow<HomeMoviesState> = _moviesState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _moviesState.value = _moviesState.value.copy(loading = true)

            val popular = tmdbRepository.getPopularMovies()
            val discover = tmdbRepository.getDiscoverMovie()
            val discoverTv = tmdbRepository.getDiscoverTv()
            val topRated = tmdbRepository.getTopRatedMovies()
            val airingToday = tmdbRepository.getAiringTodaySerie()
            val onTheAir = tmdbRepository.getOnTheAirSeries()
            val dayTrendingMovies = tmdbRepository.getDayTrendingMovies()
            val weekTrendingMovies = tmdbRepository.getWeekTrendingMovies()
            val dayTrendingSerie = tmdbRepository.getDayTrendingSerie()
            val weekTrendingSerie = tmdbRepository.getWeekTrendingSerie()
            val upcoming = tmdbRepository.getUpcomingMovies()

            _moviesState.value = HomeMoviesState(
                popularMovies = popular,
                discoverMovies = discover,
                discoverTv = discoverTv,
                airingTodaySerie = airingToday,
                onTheAirSeries = onTheAir,
                dayTrendingSerie = dayTrendingSerie,
                weekTrendingSerie = weekTrendingSerie,
                topRatedMovies = topRated,
                dayTrendingMovies = dayTrendingMovies,
                weekTrendingMovies = weekTrendingMovies,
                upcomingMovies = upcoming,
                loading = false
            )
        }
    }
}