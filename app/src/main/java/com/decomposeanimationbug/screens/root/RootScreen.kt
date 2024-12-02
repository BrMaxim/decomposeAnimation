package com.decomposeanimationbug.screens.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.decomposeanimationbug.screens.loader.LoaderScreen
import com.decomposeanimationbug.screens.navigation.NavigationScreen
import com.decomposeanimationbug.screens.stuck.StuckScreen

@Composable
fun RootScreen(
    modifier: Modifier = Modifier,
    component: RootComponent
) {
    Children(
        modifier = modifier,
        stack = component.stack,
        animation = stackAnimation { child, otherChild, _ ->
            slide()
        }
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Navigation -> NavigationScreen(component = child.component)
            is RootComponent.Child.Stuck -> StuckScreen(component = child.component)
            is RootComponent.Child.Loader -> LoaderScreen(component = child.component)
        }
    }
}