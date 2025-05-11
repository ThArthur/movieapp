package dev.rokku.rokkumovie.presentation.ui.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import dev.rokku.rokkumovie.data.response.Genre
import dev.rokku.rokkumovie.presentation.data.model.MediaDetail
import dev.rokku.rokkumovie.presentation.ui.components.MovieListComponent
import dev.rokku.rokkumovie.presentation.ui.components.RatingComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onMovieClick: (Int, String) -> Unit,
) {

    val media by viewModel.media.collectAsState()
    val similarMovies by viewModel.similarMovies.collectAsState()
    val recommendedMovies by viewModel.recommendedMovies.collectAsState()

    val scrollState = rememberScrollState()
    val isAtTop by remember { derivedStateOf { scrollState.value < 230 } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isAtTop) {
                        Color.Transparent
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
            )
        }
    ) {
        media?.let {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                MovieImageBackdrop(movie = it)
                MovieDescriptionSection(description = it.overview)

                MovieListComponent(
                    sectionTitle = "Similar Movies",
                    mediaItems = similarMovies,
                    onMovieClick = onMovieClick
                )

                MovieListComponent(
                    sectionTitle = "Recommended Movies",
                    mediaItems = recommendedMovies,
                    onMovieClick = onMovieClick
                )
            }

        } ?: run {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }

}

@Composable
fun MovieImageBackdrop(
    modifier: Modifier = Modifier,
    movie: MediaDetail
) {

    Box(
        modifier = modifier
            .height(350.dp)
            .fillMaxWidth()
    ) {

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original/${movie.backdropPath}",
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background.copy(alpha = 1.5f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(
                5.dp,
                Alignment.Bottom
            )
        ) {
            Text(
                movie.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                letterSpacing = 2.sp
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
//                val hours = movie.runtime / 60
//                val minutes = movie.runtime % 60
//
//                Text("${hours}h ${minutes}min")

                RatingComponent(rating = movie.voteAverage)

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (genre in movie.genres) {
                    MovieGenreBadge(genreBadge = genre)
                }
            }
        }
    }
}

@Composable
fun MovieDescriptionSection(description: String) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            "Resume",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
        )

    }

}

@Composable
fun MovieGenreBadge(genreBadge: Genre) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.small
            )
            .clip(MaterialTheme.shapes.small)
            .clickable { }
            .padding(5.dp)
    ) {
        Text(genreBadge.name)
    }
}