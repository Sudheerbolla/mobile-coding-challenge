package com.audiobookstask.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.audiobookstask.data.model.PodcastsModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastDetails(onBackClick: () -> Unit,
                   podcastsModel: PodcastsModel) {
    Scaffold(
        topBar = { DetailTopAppBar(onBackClick) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                Modifier
                    .padding(
                        top = it.calculateTopPadding(),
                        start = 15.dp, end = 15.dp
                    )
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = podcastsModel.title!!,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = podcastsModel.publisher!!,
                    style = MaterialTheme.typography.bodyMedium,
                )
                val painterMain =
                    rememberAsyncImagePainter(model = podcastsModel.image)
                Image(
                    painter = painterMain,
                    contentDescription = "Thumb for ${podcastsModel.title}",
                    modifier = Modifier
                        .size(300.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                )
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(
                        text = "Favourite",
                        color = Color.White
                    )
                }
                Text(
                    text = podcastsModel.description!!,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}