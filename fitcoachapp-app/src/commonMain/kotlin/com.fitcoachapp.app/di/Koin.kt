package com.fitcoachapp.app.di

import com.fitcoachapp.feature.auth.ui.di.getAuthModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(
    enableNetworkLogs: Boolean = false,
    baseUrl: String,
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    modules(commonModule(enableNetworkLogs = enableNetworkLogs, baseUrl) + getAuthModules())
}

// called by iOS etc
fun initKoin(baseUrl: String) = initKoin(enableNetworkLogs = true, baseUrl = baseUrl) {}

fun commonModule(
    enableNetworkLogs: Boolean,
    baseUrl: String,
) = module {

}




