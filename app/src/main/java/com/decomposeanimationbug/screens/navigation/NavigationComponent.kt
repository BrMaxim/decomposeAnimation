package com.decomposeanimationbug.screens.navigation

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.decomposeanimationbug.screens.list.ListComponent

@Immutable
interface NavigationComponent {

    val stack: Value<ChildStack<*, Child>>

    @Immutable
    sealed class Child {
        class List(val component: ListComponent) : Child()
    }
}