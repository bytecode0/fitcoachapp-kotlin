package com.fitcoachapp.feature.auth.ui.di

import com.fitcoachapp.feature.auth.domain.repositories.IUserRepository
import com.fitcoachapp.feature.auth.domain.usecases.GetUserUseCase
import com.fitcoachapp.feature.auth.ui.getDispatcherProvider
import com.fitcoachapp.firebase.firestore.IUserFirestoreClient
import com.fitcoachapp.firebase.firestore.UserFirestoreClient
import com.fitcoachapp.firebase.repositories.UserRepository
import org.koin.dsl.module


fun getAuthModules() = listOf(commonModule, firestoreModule, repositoryModule, usecaseModule)

val commonModule = module {
    single { getDispatcherProvider() }
}

val firestoreModule = module {
    factory<IUserFirestoreClient> { UserFirestoreClient() }
}

val repositoryModule = module {
    factory<IUserRepository> { UserRepository(get()) }
}

val usecaseModule = module {
    factory { GetUserUseCase(getDispatcherProvider().io, get()) }
}


