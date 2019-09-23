package com.example.sample_mvvm_databinding

import android.app.Application
import com.example.sample_mvvm_databinding.di.appModules
import org.koin.android.ext.android.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}