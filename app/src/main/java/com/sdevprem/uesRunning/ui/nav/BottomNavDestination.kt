package com.sdevprem.uesRunning.ui.nav

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.sdevprem.runtrack.R

sealed class BottomNavDestination(
    route: String,
    @DrawableRes
    val icon: Int
) : Destination(route) {

    @Composable
    fun getIconVector() = ImageVector.vectorResource(icon)

    object Home : BottomNavDestination(route = "Inicio", icon = R.drawable.baseline_home_24) {

        fun navigateToOnBoardingScreen(navController: NavController) {
            navController.navigate(OnBoardingDestination.route)
        }

        fun navigateToRunStats(navController: NavController) {
            navController.navigate(RunStats.route)
        }

        object RecentRun : Destination("Carrera reciente") {
            fun navigateToRunningHistoryScreen(navController: NavController) {
                navController.navigate(RunningHistory.route)
            }
        }

        object RunningHistory : Destination("Historial")

    }

    object Profile : BottomNavDestination(route = "Perfil", icon = R.drawable.baseline_person_24)

}