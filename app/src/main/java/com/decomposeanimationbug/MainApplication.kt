package com.decomposeanimationbug

import android.app.Application
import com.decomposeanimationbug.screens.list.ListFactory
import com.decomposeanimationbug.screens.loader.LoaderFactory
import com.decomposeanimationbug.screens.navigation.NavigationFactory
import com.decomposeanimationbug.screens.root.RootFactory
import com.decomposeanimationbug.screens.stuck.StuckFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(
                module {
                    factoryOf(::RootFactory)
                    factoryOf(::NavigationFactory)
                    factoryOf(::ListFactory)
                    factoryOf(::StuckFactory)
                    factoryOf(::LoaderFactory)
                }
            ))
        }
    }
}