package com.decomposeanimationbug.screens.loader

import com.arkivanov.decompose.ComponentContext

class LoaderFactory() {

    fun create(
        componentContext: ComponentContext,
        openNextScreen: () -> Unit
    ): LoaderComponent {
        return LoaderComponentImpl(
            componentContext,
            openNextScreen
        )
    }
}