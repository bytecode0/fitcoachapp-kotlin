package com.fitcoachapp.feature.auth.ui

import kotlinx.coroutines.Dispatchers

/**
 * A Dispatcher abstraction in order to ease testing coroutines
 */
internal actual fun getDispatcherProvider(): DispatcherProvider = AndroidDispatcherProvider()

private class AndroidDispatcherProvider: DispatcherProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}