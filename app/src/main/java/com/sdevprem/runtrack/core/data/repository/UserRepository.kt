package com.sdevprem.runtrack.core.data.repository

import androidx.core.net.toUri
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sdevprem.runtrack.core.data.model.Gender
import com.sdevprem.runtrack.core.data.model.User
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        val USER_NAME = stringPreferencesKey("nombre_usuario")
        val USER_GENDER = stringPreferencesKey("genero_usuario")
        val USER_WEIGHT_IN_KG = floatPreferencesKey("kilogramos_usuario")
        val USER_WEEKLY_GOAL_IN_KM = floatPreferencesKey("kilimetros_usuario")
        val USER_IMG_URI = stringPreferencesKey("foto_usuario")
    }

    val user = dataStore.data.map {
        val dbImgUri = it[USER_IMG_URI]
        User(
            name = it[USER_NAME] ?: "",
            gender = Gender.valueOf(it[USER_GENDER] ?: Gender.MALE.name),
            weightInKg = it[USER_WEIGHT_IN_KG] ?: 0.0f,
            weeklyGoalInKM = it[USER_WEEKLY_GOAL_IN_KM] ?: 0.0f,
            imgUri = if (dbImgUri.isNullOrBlank()) null else dbImgUri.toUri()
        )
    }

    val doesUserExist = dataStore.data.map {
        it[USER_NAME] != null
    }

    suspend fun updateUser(user: User) = dataStore.edit {
        it[USER_NAME] = user.name
        it[USER_GENDER] = user.gender.name
        it[USER_WEEKLY_GOAL_IN_KM] = user.weeklyGoalInKM
        it[USER_WEIGHT_IN_KG] = user.weightInKg
        it[USER_IMG_URI] = user.imgUri?.toString() ?: ""
    }
}