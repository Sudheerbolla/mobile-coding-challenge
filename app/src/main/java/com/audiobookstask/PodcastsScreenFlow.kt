package com.audiobookstask

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.audiobookstask.ui.theme.AudioBooksTaskTheme
import com.audiobookstask.utils.Const
import com.audiobookstask.utils.CustomRoute
import com.audiobookstask.utils.Utils
import com.audiobookstask.view.PodcastDetails
import com.audiobookstask.view.fragments.PodcastsScreen

@Composable
fun PodcastsScreenFlow() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = CustomRoute.Podcasts.route) {
        composable(CustomRoute.Podcasts.route) {
            PodcastsScreen(onPodcastClick = {
                navController.navigate(CustomRoute.Detail.createRoute(it))
            })
        }
        composable(
            CustomRoute.Detail.route,
            arguments = listOf(
                navArgument(Const.DETAIL_ARG_PODCAST_ID) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val podCastId = backStackEntry.arguments?.getString(Const.DETAIL_ARG_PODCAST_ID)
            requireNotNull(podCastId) { "podCastId parameter wasn't found. Please make sure it's set!" }
            PodcastDetails(Utils.getSelectedPodcastModel(podCastId))
        }
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PodcastsScreenFlowPreview() {
    AudioBooksTaskTheme {
        PodcastsScreenFlow()
    }
}