package com.audiobookstask.data.repo

import com.audiobookstask.data.model.PodcastsResponse
import com.audiobookstask.utils.network.RetrofitInstance

class PodCastRepository {
    private val podcastsService = RetrofitInstance.podCastsService

    suspend fun getPodCasts(page: Int): PodcastsResponse {
        return podcastsService.getAllGames(page)
    }
}