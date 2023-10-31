package com.audiobookstask.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.audiobookstask.data.model.PodcastsModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastDetails(podcastsModel: PodcastsModel) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    .size(250.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Button(onClick = { /*TODO*/ }
            ) {
                Text("Favourite")
            }
            Text(
                text = podcastsModel.description!!,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}