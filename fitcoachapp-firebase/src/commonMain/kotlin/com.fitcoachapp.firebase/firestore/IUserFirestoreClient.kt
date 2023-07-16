package com.fitcoachapp.firebase.firestore

import com.fitcoachapp.firebase.models.FirestoreUser

interface IUserFirestoreClient {
    suspend fun saveUser(firestoreUser: FirestoreUser)
    suspend fun updateUser(firestoreUser: FirestoreUser)
    suspend fun deleteUser(userId: String)
    suspend fun getUser(userId: String): FirestoreUser
}