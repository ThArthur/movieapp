package dev.rokku.rokkumovie.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.rokku.rokkumovie.presentation.ui.components.MainScreen
import dev.rokku.rokkumovie.presentation.ui.screens.search.SearchScreen

fun NavGraphBuilder.searchGraph(
    navController: NavController
) {
    navigation<SearchGraph>(
        startDestination = SearchPage
    ) {

        composable<SearchPage> {
            MainScreen(navController = navController) { innerPadding ->

                SearchScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}