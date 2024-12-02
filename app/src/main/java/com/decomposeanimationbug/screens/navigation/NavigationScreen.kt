package com.decomposeanimationbug.screens.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.decomposeanimationbug.screens.list.ListScreen

@Composable
fun NavigationScreen(component: NavigationComponent) {
    Children(
        stack = component.stack,
        animation = stackAnimation(slide())
    ) {
        when (val child = it.instance) {
            is NavigationComponent.Child.List -> ListScreen(component = child.component)
        }
    }
}