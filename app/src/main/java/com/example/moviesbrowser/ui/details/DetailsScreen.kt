package com.example.moviesbrowser.ui.details

import android.media.browse.MediaBrowser
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.moviesbrowser.R
import com.example.moviesbrowser.ui.details.data.Actor
import com.example.moviesbrowser.ui.home.data.Movie






@Composable
fun DetailScreen(navController: NavController, movie: Movie) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp, vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "${movie.title}", style = MaterialTheme.typography.headlineLarge)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp, vertical = 8.dp
                ),

        ){
            Image(
                painter = painterResource(id = movie.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))
            Text(text = movie.description, style = MaterialTheme.typography.bodySmall)

        }
        Spacer(modifier = Modifier.height(32.dp))







        val playerView = remember { PlayerView(context) }


        DisposableEffect(AndroidView(factory = {playerView}, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)

        )){


            val exoPlayer = ExoPlayer.Builder(context).build()

            for (video in movie.videosList)
            {
                val url = "rawresource://${context.packageName}/${video}"
                val mediaItem = MediaItem.fromUri(Uri.parse(url))
                exoPlayer.addMediaItem(mediaItem)
            }


            playerView.player = exoPlayer

            exoPlayer.prepare()
            exoPlayer.playWhenReady= false

            onDispose {
                exoPlayer.release()

            }
        }

    


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp
                ),

        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)

                    .padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(16.dp))
                Log.d("DetailScreen", "movie.scenesImages: ${movie.scenesImages}")
                Text(text = "Sceny", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(5.dp))
                GridScenes(scenes = movie.scenesImages)

            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(16.dp))
                Log.d("DetailScreen", "movie.actorsList: ${movie.actorsList}")
                Text(text = "Aktorzy", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(5.dp))
                ActorList(actors = movie.actorsList)
            }



        }




    }
}

@Composable
fun GridScenes(scenes: List<Int>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
  )
    {
        items(scenes) { scene ->
            Image(
                painter = painterResource(id = scene),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(4.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun ActorList(actors: List<Actor>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2))
    {
        items(actors) { actor ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = actor.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = actor.name, style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Center)
            }
        }
    }
}


