package com.audiobookstask.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.utils.network.PodcastsPagingSource
import com.audiobookstask.utils.network.PodcastsService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PodcastsRepositoryImpl @Inject constructor(
    private val podcastsService: PodcastsService,
    private val pageSize: Int
) : PodcastsRepository {
    override fun getAllPodcasts(): Flow<PagingData<PodcastsModel>> = Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                PodcastsPagingSource(
                    response = { pageNext ->
                        podcastsService.getAllGames(
                            page = pageNext
                        )
                    }
                )
            }
        ).flow


    override fun getDetailPodcasts(id: Int): Flow<retrofit2.Response<PodcastsModel>> {
        /*try {
            emit(Response.Loading)
            val responseApi = podcastsService.getPodcastsDetail(
                id = id,
                key = pageSize
            )
            emit(Response.Success(responseApi))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)*/
        TODO("Not yet implemented")
    }

}