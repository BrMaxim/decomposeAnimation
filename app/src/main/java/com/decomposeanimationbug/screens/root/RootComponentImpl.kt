package com.decomposeanimationbug.screens.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.value.Value
import com.decomposeanimationbug.screens.loader.LoaderFactory
import com.decomposeanimationbug.screens.navigation.NavigationFactory
import com.decomposeanimationbug.screens.stuck.StuckFactory
import kotlinx.serialization.Serializable

class RootComponentImpl(
    componentContext: ComponentContext,
    private val loaderFactory: LoaderFactory,
    private val navigationFactory: NavigationFactory,
    private val stuckFactory: StuckFactory
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Loader,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = _stack

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            Config.Loader -> RootComponent.Child.Loader(loaderFactory.create(componentContext) {
                navigation.pushToFront(Config.Navigation)
            })

            Config.Navigation -> RootComponent.Child.Navigation(
                navigationFactory.create(
                    componentContext
                ) { navigation.pushToFront(Config.Stuck) }
            )

            Config.Stuck -> RootComponent.Child.Stuck(stuckFactory.create(componentContext))
        }

    @Serializable
    sealed class Config {
        @Serializable
        data object Loader : Config()

        @Serializable
        data object Navigation : Config()

        @Serializable
        data object Stuck : Config()
    }
}