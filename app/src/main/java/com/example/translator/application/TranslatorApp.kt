package com.example.translator.application

import android.app.Application
import com.example.translator.dagger.application
import com.example.translator.dagger.historyScreen
import com.example.translator.dagger.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
