package com.fitcoachapp.feature.auth.domain.models

data class FitCoachAppUser(
    val id: String = "",
    val userId: String = "",
    val email: String = "",
    val name: String = "",
    val profileImage: String = ""
)