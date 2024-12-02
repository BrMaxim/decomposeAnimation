package com.decomposeanimationbug.screens.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.decomposeanimationbug.screens.list.ListFactory
import kotlinx.serialization.Serializable

class NavigationComponentImpl(
    componentContext: ComponentContext,
    private val listFactory: ListFactory,
    private val openStuck: () -> Unit
) : ComponentContext by componentContext, NavigationComponent {

    private val navigation = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.List,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, NavigationComponent.Child>>
        get() = _stack

    private fun child(config: Config, componentContext: ComponentContext): NavigationComponent.Child =
        when (config) {
            Config.List -> NavigationComponent.Child.List(listFactory.create(componentContext, openStuck))
        }

    @Serializable
    sealed class Config {
        @Serializable
        data object List : Config()
    }
}