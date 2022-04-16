package com.jamshid.foodappsql

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.jamshid.foodappsql.di.dataModule
import com.jamshid.foodappsql.di.networkModule
import com.jamshid.foodappsql.di.useCaseModule
import com.jamshid.foodappsql.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val modules= listOf(viewModelModule, networkModule, dataModule, useCaseModule)
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }
    }
}