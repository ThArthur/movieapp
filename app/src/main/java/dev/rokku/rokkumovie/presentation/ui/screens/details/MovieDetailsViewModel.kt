package dev.rokku.rokkumovie.presentation.ui.screens.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rokku.rokkumovie.data.TmdbRepository
import dev.rokku.rokkumovie.presentation.data.model.MediaDetail
import dev.rokku.rokkumovie.presentation.data.model.MovieModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val tmdbRepository: TmdbRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _media = MutableStateFlow<MediaDetail?>(null)
    val media: StateFlow<MediaDetail?> = _media.asStateFlow()

    private val _similarMovies = MutableStateFlow<List<MovieModel>>(emptyList())
    val similarMovies: StateFlow<List<MovieModel>> = _similarMovies.asStateFlow()

    private val _recommendedMovies = MutableStateFlow<List<MovieModel>>(emptyList())
    val recommendedMovies: StateFlow<List<MovieModel>> = _recommendedMovies.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        val movieId = savedStateHandle.get<Int>("id")
        val mediaType = savedStateHandle.get<String>("mediaType")

        if (movieId != null && mediaType != null) {
            fetchMediaById(
                movieId,
                mediaType
            )
            fetchSimilarMovies(movieId)
            fetchRecommendedMovies(movieId)
        } else {
            Log.e(
                "MovieDetailsViewModel",
                "Parâmetros inválidos: movieId=$movieId, mediaType=$mediaType"
            )
        }

    }

    private fun fetchMediaById(
        movieId: Int,
        mediaType: String
    ) {
        viewModelScope.launch {
            try {
                _loading.value = true
                when (mediaType) {
                    "movie" -> {
                        tmdbRepository.getMovieById(movieId)
                            .onSuccess { _media.value = it }
                            .onFailure {
                                _media.value = null
                            }
                    }
                    "tv" -> {
                        tmdbRepository.getSerieById(serieId = movieId)
                            .onSuccess { _media.value = it }
                            .onFailure {
                                _media.value = null
                            }
                    }
                }
            } finally {
                _loading.value = false
            }
        }
    }

    private fun fetchSimilarMovies(movieId: Int) {
        viewModelScope.launch {
            try {
                _loading.value = true
                _similarMovies.value = tmdbRepository.similarMovies(movieId)
            } finally {
                _loading.value = false
            }
        }
    }

    private fun fetchRecommendedMovies(movieId: Int) {
        viewModelScope.launch {
            try {
                _loading.value = true
                _recommendedMovies.value = tmdbRepository.recommendedMovies(movieId)
            } finally {
                _loading.value = false
            }
        }
    }

}