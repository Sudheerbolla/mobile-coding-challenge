package com.audiobookstask.view.fragments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.utils.podcasts
import com.audiobookstask.view.fragments.uicomp.PodcastsList

@Composable
fun PodcastsScreen(
    podcastsList: List<PodcastsModel> = podcasts,
//    podcastsViewModel: PodcastsViewModel = hiltViewModel(),
    onPodcastClick: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        PodcastsList(
            podcastsList = podcastsList,
//            podcastsList = podcastsViewModel.podcastsListState.collectAsLazyPagingItems(),
            onPodcastClick = onPodcastClick,
        )
    }
}