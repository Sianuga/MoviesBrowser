// ui/MovieListScreen.kt
package com.example.moviebrowser.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesbrowser.ui.home.data.Movie
import com.example.moviesbrowser.ui.home.data.movies

@Composable
fun HomeScreen(
    navController: NavController
) {
    LazyColumn {
        items(movies) { movie ->
            MovieListItem(movie = movie, onMovieClick = {
                navController.navigate("movie/${movie.id}")
            })
        }
    }
}

@Composable
fun MovieListItem(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMovieClick(movie) }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = movie.scenesImages.first()),
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
    }
}
