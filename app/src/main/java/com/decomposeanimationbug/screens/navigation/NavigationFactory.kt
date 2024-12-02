package com.decomposeanimationbug.screens.navigation

import com.arkivanov.decompose.ComponentContext
import com.decomposeanimationbug.screens.list.ListFactory

class NavigationFactory(
    private val listFactory: ListFactory,
) {

    fun create(
        componentContext: ComponentContext,
        openStuck: () -> Unit
    ): NavigationComponent {
        return NavigationComponentImpl(
            componentContext,
            listFactory,
            openStuck
        )
    }
}