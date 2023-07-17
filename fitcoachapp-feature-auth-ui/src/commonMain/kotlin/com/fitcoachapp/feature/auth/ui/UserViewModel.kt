package com.fitcoachapp.feature.auth.ui

import com.fitcoachapp.feature.auth.domain.CoroutineUseCase
import com.fitcoachapp.feature.auth.domain.models.FitCoachAppUser
import com.fitcoachapp.feature.auth.domain.usecases.GetUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class UserViewModel: KoinComponent {
    private val dispatcherProvider: DispatcherProvider = getDispatcherProvider()
    private val viewModelScope = CoroutineScope(dispatcherProvider.io)
    private val getUserUseCase: GetUserUseCase = get()

    private val _userStateFlow: MutableStateFlow<FitCoachAppUIUser> = MutableStateFlow(FitCoachAppUIUser())
    val userStateFlow = _userStateFlow

    init {
        getUser("1234")
    }

    fun saveUser(
        user: FitCoachAppUIUser
    ) {
        viewModelScope.launch {

        }
    }

    fun updateUser(
        user: FitCoachAppUIUser
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
            getUserUseCase.invoke(userId).let { result ->
                when (result) {
                    is com.fitcoachapp.feature.auth.domain.Result.Success -> {
                        _userStateFlow.value = FitCoachAppUIUser(
                            id = result.data.id,
                            email = result.data.email,
                            name = result.data.name,
                            profileImage = result.data.profileImage
                        )
                    }
                    is com.fitcoachapp.feature.auth.domain.Result.Error -> {
                        println("Error: ${result.message}")
                    }
                    else -> {
                        println("Unexpected error")
                    }
                }
            }
        }
    }
}

data class FitCoachAppUIUser (
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val profileImage: String = ""
)