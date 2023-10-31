package com.audiobookstask.utils

import com.audiobookstask.data.model.PodcastsModel

object Utils {

    fun getSelectedPodcastModel(pid: String): PodcastsModel {
        return podcasts.first {
            it.id == pid
        }
    }
}