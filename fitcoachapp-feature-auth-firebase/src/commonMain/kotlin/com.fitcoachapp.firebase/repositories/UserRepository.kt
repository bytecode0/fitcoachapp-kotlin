package com.fitcoachapp.firebase.repositories

import com.fitcoachapp.feature.auth.domain.models.FitCoachAppUser
import com.fitcoachapp.feature.auth.domain.repositories.IUserRepository
import com.fitcoachapp.firebase.firestore.IUserFirestoreClient
import com.fitcoachapp.firebase.models.FirestoreUser

class UserRepository(
    private val userFirestoreClient: IUserFirestoreClient
): IUserRepository {

    override suspend fun saveUser(user: FitCoachAppUser) {
        userFirestoreClient.saveUser(
            FirestoreUser(
                id = user.id,
                name = user.name,
                email = user.email,
                profileImage = user.profileImage
            )
        )
    }

    override suspend fun updateUser(user: FitCoachAppUser) {
        userFirestoreClient.updateUser(
            FirestoreUser(
                id = user.id,
                name = user.name,
                email = user.email,
                profileImage = user.profileImage
            )
        )
    }

    override suspend fun deleteUser(userId: String) {
        userFirestoreClient.deleteUser(userId)
    }

    override suspend fun getUser(userId: String): FitCoachAppUser {
        userFirestoreClient.getUser(userId).let {
            return FitCoachAppUser(
                id = it.id,
                name = it.name,
                email = it.email,
                profileImage = it.profileImage
            )
        }
    }
}