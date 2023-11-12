package com.audiobookstask.utils.network

import com.audiobookstask.data.model.PodcastsResponse
import com.audiobookstask.data.model.PodcastsModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastsService {

    @GET("best_podcasts")
    suspend fun getAllGames(@Query("page") page: Int): PodcastsResponse

    @GET("games/{id}")
    suspend fun getPodcastsDetail(
        @Path("id") id: Int, @Query("key") key: String,
    ): PodcastsModel

}