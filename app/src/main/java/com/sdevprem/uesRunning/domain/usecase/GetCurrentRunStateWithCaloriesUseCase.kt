package com.sdevprem.uesRunning.domain.usecase

import com.sdevprem.uesRunning.core.data.repository.UserRepository
import com.sdevprem.uesRunning.core.tracking.TrackingManager
import com.sdevprem.uesRunning.domain.model.CurrentRunStateWithCalories
import com.sdevprem.uesRunning.utils.RunUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToInt

@Singleton
class GetCurrentRunStateWithCaloriesUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val trackingManager: TrackingManager
) {
    operator fun invoke(): Flow<CurrentRunStateWithCalories> {
        return combine(userRepository.user, trackingManager.currentRunState) { user, runState ->
            CurrentRunStateWithCalories(
                currentRunState = runState,
                caloriesBurnt = RunUtils.calculateCaloriesBurnt(
                    distanceInMeters = runState.distanceInMeters,
                    weightInKg = user.weightInKg
                ).roundToInt()
            )
        }
    }
}