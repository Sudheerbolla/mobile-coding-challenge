package com.audiobookstask.utils

import com.audiobookstask.utils.Const.DETAIL_ARG_PODCAST_ID
import com.audiobookstask.utils.Const.DETAIL_SCREEN
import com.audiobookstask.utils.Const.PODCASTS_SCREEN

sealed class CustomRoute(val route: String) {
    object Podcasts : CustomRoute(PODCASTS_SCREEN)
    object Detail : CustomRoute("$DETAIL_SCREEN/{$DETAIL_ARG_PODCAST_ID}") {
        fun createRoute(podcastId: String) = "$DETAIL_SCREEN/$podcastId"
    }
}