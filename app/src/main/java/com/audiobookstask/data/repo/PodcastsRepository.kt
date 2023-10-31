package com.audiobookstask.data.repo

import androidx.paging.PagingData
import com.audiobookstask.data.model.PodcastsModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PodcastsRepository {
    fun getAllPodcasts(): Flow<PagingData<PodcastsModel>>
    fun getDetailPodcasts(id: Int): Flow<Response<PodcastsModel>>
}