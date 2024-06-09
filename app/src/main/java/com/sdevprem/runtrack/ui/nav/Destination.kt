package com.sdevprem.runtrack.ui.nav

import androidx.navigation.NavController
import androidx.navigation.navDeepLink

sealed class Destination(val route: String) {

    object OnBoardingDestination : Destination("Icorporarme") {
        fun navigateToHome(navController: NavController) {
            navController.navigate(BottomNavDestination.Home.route) {
                popUpTo(route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    object CurrentRun : Destination("Carrera actual") {
        val currentRunUriPattern = "https://runtrack.sdevprem.com/$route"
        val deepLinks = listOf(
            navDeepLink {
                uriPattern = currentRunUriPattern
            }
        )
    }

    data object RunStats : Destination("Estadística de carreras")

    //global navigation
    companion object {
        fun navigateToCurrentRunScreen(navController: NavController) {
            navController.navigate(CurrentRun.route)
        }
    }

}
