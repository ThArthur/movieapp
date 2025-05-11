package dev.rokku.rokkumovie.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
//        bottomBar = {
//            NavigationBarComponent(navController = navController)
//        }
    ) { innerPadding ->
        content(innerPadding)
    }
}