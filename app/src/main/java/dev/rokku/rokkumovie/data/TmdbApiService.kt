package dev.rokku.rokkumovie.data

import dev.rokku.rokkumovie.data.response.MovieByIdResponse
import dev.rokku.rokkumovie.data.response.MovieResponse
import dev.rokku.rokkumovie.data.response.airing_today_serie.AiringTodaySerieResponse
import dev.rokku.rokkumovie.data.response.discover_movie.DiscoverMovieResponse
import dev.rokku.rokkumovie.data.response.discover_tv.DiscoverTvResponse
import dev.rokku.rokkumovie.data.response.on_the_air.OnTheAirSeriesResponse
import dev.rokku.rokkumovie.data.response.serie.SerieByIdResponse
import dev.rokku.rokkumovie.data.response.top_rated_movie.TopRatedMovieResponse
import dev.rokku.rokkumovie.data.response.trending_movies.TrendingMoviesResponse
import dev.rokku.rokkumovie.data.response.trending_serie.TrendingSeriesResponse
import dev.rokku.rokkumovie.data.response.upcoming_movie.UpcomingMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {

    @GET("discover/movie")
    suspend fun getDiscoverMovie(
        @Query("page")
        page: Int
    ): DiscoverMovieResponse

    @GET("discover/tv")
    suspend fun getDiscoverTv(
        @Query("page")
        page: Int,
        @Query("include_adult")
        includeAdult: Boolean = false
    ): DiscoverTvResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page")
        page: Int
    ): TopRatedMovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page")
        page: Int
    ): UpcomingMovieResponse

    @GET("tv/airing_today")
    suspend fun getAiringTodaySerie(
        @Query("page")
        page: Int
    ): AiringTodaySerieResponse

    @GET("trending/movie/day")
    suspend fun getDayTrendingMovies(
        @Query("page")
        page: Int
    ): TrendingMoviesResponse

    @GET("trending/movie/week")
    suspend fun getWeekTrendingMovies(
        @Query("page")
        page: Int
    ): TrendingMoviesResponse

    @GET("trending/tv/day")
    suspend fun getDayTrendingSerie(
        @Query("page")
        page: Int
    ): TrendingSeriesResponse

    @GET("trending/tv/week")
    suspend fun getWeekTrendingSerie(
        @Query("page")
        page: Int
    ): TrendingSeriesResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirSeries(
        @Query("page")
        page: Int
    ): OnTheAirSeriesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id")
        movieId: Int
    ): MovieByIdResponse

    @GET("tv/{serie_id}")
    suspend fun getSerieById(
        @Path("serie_id")
        serieId: Int
    ): SerieByIdResponse

    @GET("movie/{movie_id}/similar")
    suspend fun similarMovies(
        @Path("movie_id")
        movieId: Int
    ): MovieResponse

    @GET("movie/{movie_id}/recommendations")
    suspend fun recommendedMovies(
        @Path("movie_id")
        movieId: Int
    ): MovieResponse

}