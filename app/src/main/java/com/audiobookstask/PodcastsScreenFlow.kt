package com.audiobookstask

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.audiobookstask.utils.Const
import com.audiobookstask.utils.CustomRoute
import com.audiobookstask.view.PodcastDetails
import com.audiobookstask.view.fragments.PodcastsScreen
import com.audiobookstask.viewmodels.PodcastsViewModel

@Composable
fun PodcastsScreenFlow(viewModel: PodcastsViewModel) {

    val navController = rememberNavController()
    NavHost(navController, startDestination = CustomRoute.Podcasts.route) {
        composable(CustomRoute.Podcasts.route) {
            PodcastsScreen(podcastsViewModel = viewModel,
                onPodcastClick = {
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
            PodcastDetails(
                onBackClick = {
//                navController.popBackStack()
                    navController.navigateUp()
                },
                viewModel.getSelectedPodCastItem(podCastId)
            )
        }
    }
}