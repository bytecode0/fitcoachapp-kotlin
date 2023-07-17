package com.fitcoachapp.android

import android.app.Application
import com.fitcoachapp.app.di.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // TODO: Change your base url from here
        initKoin(enableNetworkLogs = true, baseUrl = "Your base url here") {}
    }
}
