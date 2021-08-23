package com.example.gamingnews

import android.app.Application
import com.example.gamingnews.di.networkModule
import com.example.gamingnews.di.repositoryModule
import com.example.gamingnews.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class GamingNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GamingNewsApplication)  // 3
            modules(repositoryModule, viewModelModule, networkModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}