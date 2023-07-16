package com.fitcoachapp.firebase.repositories

import com.fitcoachapp.feature.auth.domain.models.FitCoachAppUser

interface IUserRepository {
    suspend fun saveUser(user: FitCoachAppUser)
    suspend fun updateUser(user: FitCoachAppUser)
    suspend fun deleteUser(userId: String)
    suspend fun getUser(userId: String): FitCoachAppUser
}