package dev.rokku.rokkumovie.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import dev.rokku.rokkumovie.R
import dev.rokku.rokkumovie.presentation.data.model.MovieModel
import dev.rokku.rokkumovie.util.shimmerEffect

val LocalOnMovieClick = staticCompositionLocalOf<((Int, String) -> Unit)?> { null }

@Composable
fun MovieListComponent(
    modifier: Modifier = Modifier,
    sectionTitle: String = "Popular Movies",
    mediaItems: List<MovieModel>,
    onMovieClick: (Int, String) -> Unit
) {

    CompositionLocalProvider(LocalOnMovieClick provides onMovieClick) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sectionTitle,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                if (mediaItems.isNotEmpty()) {
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .clickable { }
                    )
                }
            }

            PopularMovieList(mediaItems)
        }
    }
}

@Composable
fun PopularMovieList(
    mediaItems: List<MovieModel>
) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        if (mediaItems.isNotEmpty()) {

            items(mediaItems) { mediaItem ->
                PopularMovieItem(mediaItem)
            }
        } else {
            item {
                Text("No movies found")
            }
        }
    }
}

@Composable
fun PopularMovieItem(
    mediaItem: MovieModel
) {
    val onMovieClick = LocalOnMovieClick.current

    Column(
        modifier = Modifier
            .width(100.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/original${mediaItem.posterPath}")
                .build(),
            contentDescription = mediaItem.title,
            contentScale = ContentScale.FillHeight,
            loading = {
                Box(modifier = Modifier.shimmerEffect())
            },
            error = {
                Image(
                    painter = painterResource(id = R.drawable.image_error),
                    contentDescription = mediaItem.title
                )
            },
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f / 1.5f)
                .clip(RoundedCornerShape(5.dp))
                .clickable {
                    onMovieClick?.invoke(
                        mediaItem.id,
                        mediaItem.mediaType
                    )
                }
        )

        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.labelLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
