package com.audiobookstask.view.fragments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.utils.podcasts
import com.audiobookstask.view.fragments.uicomp.PodcastsList
import com.audiobookstask.viewmodels.PodcastsViewModel

@Composable
fun PodcastsScreen(
    podcastsViewModel: PodcastsViewModel,
    onPodcastClick: (String) -> Unit = {},
) {
    val podCasts by podcastsViewModel.podCasts.observeAsState(null)

    LaunchedEffect(Unit) {
        podcastsViewModel.fetchPodCasts()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (podCasts == null) {
            Text(text = "Loading...")
        } else {
            PodcastsList(
                podcastsList = podCasts!!.podcasts,
                onPodcastClick = onPodcastClick,
            )
        }

    }
}