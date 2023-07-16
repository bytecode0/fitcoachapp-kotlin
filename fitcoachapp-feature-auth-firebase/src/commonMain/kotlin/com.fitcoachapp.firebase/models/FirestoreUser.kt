package com.fitcoachapp.firebase.models

import kotlinx.serialization.Serializable

@Serializable
data class FirestoreUser(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val profileImage: String = "",
    val userId: String = "",
    val fcmToken: String = ""
)