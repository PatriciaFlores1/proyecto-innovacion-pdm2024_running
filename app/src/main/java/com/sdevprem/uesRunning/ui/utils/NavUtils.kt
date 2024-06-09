package com.sdevprem.uesRunning.ui.utils

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.sdevprem.uesRunning.ui.nav.BottomNavDestination

fun NavController.navigateToBottomNavDestination(item: BottomNavDestination) {
    navigate(item.route) {
        popUpTo(graph.findStartDestination().id) {
            this.saveState = true
        }
        restoreState = true
        launchSingleTop = true
    }
}