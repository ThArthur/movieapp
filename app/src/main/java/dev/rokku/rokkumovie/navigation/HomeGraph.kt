package dev.rokku.rokkumovie.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.rokku.rokkumovie.presentation.ui.components.MainScreen
import dev.rokku.rokkumovie.presentation.ui.screens.details.MovieDetailsScreen
import dev.rokku.rokkumovie.presentation.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation<HomeGraph>(
        startDestination = HomePage
    ) {
        composable<HomePage> {
            MainScreen(navController = navController) { innerPadding ->
                HomeScreen(
                    modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
                    onMovieClick = { movieId, mediaType ->
                        navController.navigate(
                            MovieDetailsPage(
                                movieId,
                                mediaType
                            )
                        )
                    }
                )
            }
        }

        composable<MovieDetailsPage> {

            MovieDetailsScreen(
                onBackClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                },
                onMovieClick = { movieId, mediaType ->
                    navController.navigate(
                        MovieDetailsPage(
                            movieId,
                            mediaType
                        )
                    )
                }
            )
        }
    }
}