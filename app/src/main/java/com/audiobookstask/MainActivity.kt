package com.audiobookstask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.audiobookstask.ui.theme.AudioBooksTaskTheme
import com.audiobookstask.viewmodels.PodcastsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: PodcastsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioBooksTaskTheme {
                PodcastsScreenFlow(viewModel)
            }
        }
    }
}