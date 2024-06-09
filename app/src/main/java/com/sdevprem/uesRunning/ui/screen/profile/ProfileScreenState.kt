package com.sdevprem.uesRunning.ui.screen.profile

import com.sdevprem.uesRunning.core.data.model.User

data class ProfileScreenState(
    val totalDistanceInKm: Float = 0f,
    val totalDurationInHr: Float = 0f,
    val totalCaloriesBurnt: Long = 0,
    val user: User = User(),
    val isEditMode: Boolean = false,
    val errorMsg: String? = null
)
