package com.decomposeanimationbug.screens.root

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.decomposeanimationbug.screens.loader.LoaderComponent
import com.decomposeanimationbug.screens.navigation.NavigationComponent
import com.decomposeanimationbug.screens.stuck.StuckComponent

@Immutable
interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    @Immutable
    sealed class Child {
        class Navigation(val component: NavigationComponent) : Child()
        class Stuck(val component: StuckComponent) : Child()
        class Loader(val component: LoaderComponent) : Child()
    }
}