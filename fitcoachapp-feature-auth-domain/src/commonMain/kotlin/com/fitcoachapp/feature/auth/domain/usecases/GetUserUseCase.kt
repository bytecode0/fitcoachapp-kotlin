package com.fitcoachapp.feature.auth.domain.usecases

import com.fitcoachapp.feature.auth.domain.CoroutineUseCase
import com.fitcoachapp.feature.auth.domain.Result
import com.fitcoachapp.feature.auth.domain.models.FitCoachAppUser
import com.fitcoachapp.feature.auth.domain.repositories.IUserRepository
import kotlinx.coroutines.CoroutineDispatcher

class GetUserUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val userRepository: IUserRepository
) : CoroutineUseCase<String, FitCoachAppUser>(coroutineDispatcher) {

    override suspend fun execute(parameters: String): Result<FitCoachAppUser> {
        return try {
            Result.Success(userRepository.getUser(parameters))
        } catch (e: Exception) {
            Result.Error(e.message ?: "Error")
        }
    }
}