package dev.rokku.rokkumovie.presentation.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rokku.rokkumovie.presentation.ui.components.MovieCarousel
import dev.rokku.rokkumovie.presentation.ui.components.MovieListComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onMovieClick: (Int, String) -> Unit,
) {
    val moviesState by viewModel.moviesState.collectAsState()
    val listState = rememberLazyListState()

    when {
        moviesState.loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            LazyColumn(
                modifier = modifier,
                state = listState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    MovieCarousel(movies = moviesState.dayTrendingMovies)
                }

                val sections = listOf(
                    "Popular Movies" to moviesState.popularMovies,
                    "Discover Movies" to moviesState.discoverMovies,
                    "Discover Series" to moviesState.discoverTv,
                    "Airing Today" to moviesState.airingTodaySerie,
                    "On The Air Series" to moviesState.onTheAirSeries,
                    "Day Trending Series" to moviesState.dayTrendingSerie,
                    "Week Trending Series" to moviesState.weekTrendingSerie,
                    "Top Rated Movies" to moviesState.topRatedMovies,
                    "Week Trending Movies" to moviesState.weekTrendingMovies,
                    "Upcoming Movies" to moviesState.upcomingMovies,
                )

                sections.forEach { (title, movies) ->
                    item {
                        MovieListComponent(
                            sectionTitle = title,
                            mediaItems = movies,
                            onMovieClick = onMovieClick
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}