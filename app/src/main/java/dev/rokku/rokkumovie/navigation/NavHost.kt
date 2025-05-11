package dev.rokku.rokkumovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeGraph
    ) {
        homeGraph(navController)
        searchGraph(navController)
    }
}