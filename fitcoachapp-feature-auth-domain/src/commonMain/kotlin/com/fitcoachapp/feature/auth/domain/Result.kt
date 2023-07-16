package com.fitcoachapp.feature.auth.domain

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    class Success<out T>(val data: T) : Result<T>()
    class Unauthorized (val message: String) : Result<Nothing>()
    class Error(val message: String) : Result<Nothing>()
    class NetworkError(val message: String) : Result<Nothing>()
}