package dev.rokku.rokkumovie.presentation.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.rokku.rokkumovie.presentation.data.model.MovieModel
import kotlinx.coroutines.delay

@Composable
fun MovieCarousel(
    movies: List<MovieModel>
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { movies.size }
    )

    val isUserInteracting = remember { mutableStateOf(false) }

    LaunchedEffect(
        pagerState,
        isUserInteracting.value
    ) {
        if (isUserInteracting.value) return@LaunchedEffect

        while (!isUserInteracting.value) {
            delay(10000)

            if (!isUserInteracting.value) {

                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                    animationSpec = tween(durationMillis = 1000)
                )
            }
        }
    }


    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isUserInteracting.value = true
                        tryAwaitRelease()
                        isUserInteracting.value = false
                    }
                )
            }
    ) { index ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/original${movies[index].posterPath}")
                    .build(),
                contentDescription = movies[index].title,
                modifier = Modifier.fillMaxHeight(),
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
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    movies[index].title,
                    style = MaterialTheme.typography.displaySmall
                )

            }
        }
    }
}