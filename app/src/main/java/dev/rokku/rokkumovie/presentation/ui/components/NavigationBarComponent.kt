package dev.rokku.rokkumovie.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.rokku.rokkumovie.navigation.HomeGraph
import dev.rokku.rokkumovie.navigation.SearchGraph

data class BottomNavItem(
    var title: String,
    var route: Any,
    var selectedIcon: ImageVector,
    var hasNews: Boolean
)

@Composable
fun NavigationBarComponent(navController: NavController) {
    val bottomNavDestinations = listOf(
        BottomNavItem(
            title = "Home",
            route = HomeGraph,
            selectedIcon = Icons.Default.Home,
            hasNews = false
        ),
        BottomNavItem(
            title = "Search",
            route = SearchGraph,
            selectedIcon = Icons.Default.Search,
            hasNews = false
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        bottomNavDestinations.forEach { destination ->
            val selected = currentDestination?.hierarchy?.any {
                it.hasRoute(destination.route::class)
            } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        destination.selectedIcon,
                        contentDescription = ""
                    )
                },
                label = {
                    Text(text = destination.title)
                },
                selected = selected,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}