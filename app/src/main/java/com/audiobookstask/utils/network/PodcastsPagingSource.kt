package com.audiobookstask.utils.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.data.model.PodcastsResponse

class PodcastsPagingSource(
    private val response: suspend (Int) -> PodcastsResponse,
) : PagingSource<Int, PodcastsModel>() {

    override fun getRefreshKey(state: PagingState<Int, PodcastsModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PodcastsModel> {
        return try {
            val nextPage = params.key ?: 1
            val podcastsList = response.invoke(nextPage)
            LoadResult.Page(
                data = podcastsList.podcasts,
                prevKey = podcastsList.previousPageNumber,
                nextKey = podcastsList.nextPageNumber
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}