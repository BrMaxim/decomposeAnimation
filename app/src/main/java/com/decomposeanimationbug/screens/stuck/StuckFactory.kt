package com.decomposeanimationbug.screens.stuck

import com.arkivanov.decompose.ComponentContext

class StuckFactory() {

    fun create(componentContext: ComponentContext): StuckComponent {
        return StuckComponentImpl(componentContext)
    }
}