package com.decomposeanimationbug.screens.root

import com.arkivanov.decompose.ComponentContext
import com.decomposeanimationbug.screens.loader.LoaderFactory
import com.decomposeanimationbug.screens.navigation.NavigationFactory
import com.decomposeanimationbug.screens.stuck.StuckFactory

class RootFactory(
    private val loaderFactory: LoaderFactory,
    private val navigationFactory: NavigationFactory,
    private val stuckFactory: StuckFactory
) {

    fun create(componentContext: ComponentContext): RootComponent {
        return RootComponentImpl(
            componentContext,
            loaderFactory,
            navigationFactory,
            stuckFactory
        )
    }
}