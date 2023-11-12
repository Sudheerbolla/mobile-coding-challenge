package com.audiobookstask.view.fragments.uicomp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.audiobookstask.R
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.view.PodcastCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastsList(
    podcastsList: List<PodcastsModel>,
    /*podcastsList: LazyPagingItems<PodcastsModel>,*/
    onPodcastClick: (String) -> Unit
) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.podcasts)) }
                )
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 25.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            text = "Podcasts",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                items(podcastsList/*.itemSnapshotList*/) {
                    PodcastCard(it, onPodcastClick = { pid: String ->
                        it.id
                        onPodcastClick(pid)
                    })
                }
            }
        }
    }
}