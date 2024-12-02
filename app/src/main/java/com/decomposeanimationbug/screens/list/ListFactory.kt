package com.decomposeanimationbug.screens.list

import com.arkivanov.decompose.ComponentContext

class ListFactory() {

    fun create(
        componentContext: ComponentContext,
        openStuck: () -> Unit
    ): ListComponent {
        return ListComponentImpl(
            componentContext,
            openStuck
        )
    }
}