package com.sdevprem.uesRunning.ui.screen.onboard

import com.sdevprem.uesRunning.core.data.model.Gender

interface OnBoardingScreenEvent {
    fun updateName(name: String)
    fun updateGender(gender: Gender)
    fun updateWeight(weightInKg: Float)
    fun updateWeeklyGoal(weeklyGoalInKm: Float)
}