package com.sdevprem.uesRunning.ui.screen.home

import com.sdevprem.uesRunning.core.data.model.Run
import com.sdevprem.uesRunning.core.data.model.User
import com.sdevprem.uesRunning.domain.model.CurrentRunStateWithCalories

data class HomeScreenState(
    val runList: List<Run> = emptyList(),
    val currentRunStateWithCalories: CurrentRunStateWithCalories = CurrentRunStateWithCalories(),
    val currentRunInfo: Run? = null,
    val user: User = User(),
    val distanceCoveredInKmInThisWeek: Float = 0.0f
)
