package com.sdevprem.uesRunning.domain.model

import com.sdevprem.uesRunning.core.tracking.model.CurrentRunState

data class CurrentRunStateWithCalories(
    val currentRunState: CurrentRunState = CurrentRunState(),
    val caloriesBurnt: Int = 0
)