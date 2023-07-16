package com.fitcoachapp.firebase.firestore

import com.fitcoachapp.firebase.models.FirestoreUser
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.firestore.where


class UserFirestoreClient: IUserFirestoreClient {
    private val firestore: FirebaseFirestore by lazy { Firebase.firestore }

    override suspend fun saveUser(
        firestoreUser: FirestoreUser
    ) {
        firestore
            .collection(USER_COLLECTION)
            .add(firestoreUser)
    }

    override suspend fun updateUser(
        firestoreUser: FirestoreUser
    ) {
        firestore
            .collection(USER_COLLECTION)
            .document(firestoreUser.id)
            .set(firestoreUser)
    }

    override suspend fun deleteUser(
        userId: String
    ) {
        firestore.collection(USER_COLLECTION)
            .where(USER_ID, "==", userId)
            .get().documents.forEach { it.reference.delete() }
    }

    override suspend fun getUser(userId: String): FirestoreUser {
        val document = firestore
            .collection(USER_COLLECTION)
            .document(userId)
            .get()
        return (document to FirestoreUser).second as FirestoreUser
    }

    companion object {
        private const val USER_COLLECTION = "Users"
        private const val USER_ID = "userId"
    }
}