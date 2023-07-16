package com.fitcoachapp.feature.auth.di

import com.fitcoachapp.feature.auth.domain.di.initAuthDomainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    enableNetworkLogs: Boolean = false,
    baseUrl: String,
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    initAuthDomainModule()
}

// called by iOS etc
fun initKoin(baseUrl: String) = initKoin(enableNetworkLogs = true, baseUrl = baseUrl) {}

val commonModule = module {
    single { getDispatcherProvider() }
}

val repositoryModule = module {
    factory<IUserRepository> { UserRepository(get()) }
}

val usecaseModule = module {
    factory { GetUserUseCase(get()) }
}

