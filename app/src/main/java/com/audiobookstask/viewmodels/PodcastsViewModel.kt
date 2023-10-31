package com.audiobookstask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.data.repo.PodcastsRepository
import kotlinx.coroutines.flow.Flow

class PodcastsViewModel(
    gamesRepository: PodcastsRepository,
) : ViewModel() {

    val podcastsListState: Flow<PagingData<PodcastsModel>> =
        gamesRepository.getAllPodcasts().cachedIn(viewModelScope)
}