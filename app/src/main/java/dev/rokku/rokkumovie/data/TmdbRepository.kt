package dev.rokku.rokkumovie.data

import android.util.Log
import dev.rokku.rokkumovie.presentation.data.model.MediaDetail
import dev.rokku.rokkumovie.presentation.data.model.MovieModel
import javax.inject.Inject

class TmdbRepository @Inject constructor(private val apiService: TmdbApiService) {

    suspend fun getPopularMovies(): List<MovieModel> {
        try {
            val response = apiService.getDiscoverMovie(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getDiscoverMovie(): List<MovieModel> {
        try {
            val response = apiService.getDiscoverMovie(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getDiscoverTv(): List<MovieModel> {
        try {
            val response = apiService.getDiscoverTv(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getTopRatedMovies(): List<MovieModel> {
        try {
            val response = apiService.getTopRatedMovies(page = 1)
            return response.results.map { it.toPopularMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getAiringTodaySerie(): List<MovieModel> {
        try {
            val response = apiService.getAiringTodaySerie(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getOnTheAirSeries(): List<MovieModel> {
        try {
            val response = apiService.getOnTheAirSeries(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getDayTrendingMovies(): List<MovieModel> {
        try {
            val response = apiService.getDayTrendingMovies(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {

            return emptyList()
        }
    }

    suspend fun getWeekTrendingMovies(): List<MovieModel> {
        try {
            val response = apiService.getWeekTrendingMovies(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {

            return emptyList()
        }
    }

    suspend fun getDayTrendingSerie(): List<MovieModel> {
        try {
            val response = apiService.getDayTrendingSerie(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getWeekTrendingSerie(): List<MovieModel> {
        try {
            val response = apiService.getWeekTrendingSerie(page = 1)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getUpcomingMovies(): List<MovieModel> {
        try {
            val response = apiService.getUpcomingMovies(page = 1)
            Log.d(
                "UpcomingMovies",
                response.toString()
            )
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            Log.e(
                "UpcomingMovies",
                e.toString()
            )

            return emptyList()
        }
    }

    suspend fun getMovieById(movieId: Int): Result<MediaDetail> {
        try {
            val response = apiService.getMovieById(movieId)
            return Result.success(response.toMediaDetail())
        } catch (e: Exception) {

            return Result.failure(e)
        }
    }

    suspend fun getSerieById(serieId: Int): Result<MediaDetail> {
        try {
            val response = apiService.getSerieById(serieId)
            return Result.success(response.toMediaDetail())
        } catch (e: Exception) {

            return Result.failure(e)
        }
    }

    suspend fun similarMovies(movieId: Int): List<MovieModel> {
        try {
            val response = apiService.similarMovies(movieId)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun recommendedMovies(movieId: Int): List<MovieModel> {
        try {
            val response = apiService.recommendedMovies(movieId)
            return response.results.map { it.toMovieModel() }
        } catch (e: Exception) {
            return emptyList()
        }
    }

}