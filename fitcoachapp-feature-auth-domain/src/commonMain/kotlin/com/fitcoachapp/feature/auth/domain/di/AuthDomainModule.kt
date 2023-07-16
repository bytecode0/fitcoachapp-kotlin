package com.fitcoachapp.feature.auth.domain.di

import com.fitcoachapp.feature.auth.domain.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.dsl.module

// called by iOS etc
fun initAuthDomainModule() = startKoin {
    modules( listOf(commonModule()) )
}

fun commonModule() = module {
    utilityModule
}

private val utilityModule = module {
    factory { getDispatcherProvider() }
}