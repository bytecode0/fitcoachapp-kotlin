package com.fitcoachapp.feature.auth.ui

import com.fitcoachapp.feature.auth.domain.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class UserViewModel: KoinComponent {
    private val dispatcherProvider: DispatcherProvider = get()
    private val viewModelScope = CoroutineScope(dispatcherProvider.io)

    private val _userStateFlow: MutableStateFlow<FitcoachappUser> = MutableStateFlow(FitcoachappUser())
    val userStateFlow = _userStateFlow

    init {
        getUser("1234")
    }

    fun saveUser(
        fitcoachappUser: FitcoachappUser
    ) {
        viewModelScope.launch {

        }
    }

    fun updateUser(
        fitcoachappUser: FitcoachappUser
    ) {
        viewModelScope.launch {
        }
    }

    fun deleteUser(
        userId: String
    ) {
        viewModelScope.launch {
        }
    }

    fun getUser(userId: String) {
        viewModelScope.launch {
        }
    }
}

data class FitcoachappUser (
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val profileImage: String = "",
    val userId: String = "",
    val fcmToken: String = "")