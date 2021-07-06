package com.example.translator.application

import android.app.Application
import com.example.translator.dagger.application
import com.example.translator.dagger.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
