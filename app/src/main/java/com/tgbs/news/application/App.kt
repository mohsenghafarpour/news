package com.tgbs.news.application

import android.app.Application
import com.tgbs.news.BuildConfig
import com.tgbs.news.di.appModule
import com.tgbs.news.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Plant Timber logger in
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        /**
         * all injection modules should be added here as a koin module.
         */
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                listOf(appModule, viewModelModule)
            )
        }

    }
}