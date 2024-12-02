package com.decomposeanimationbug.screens.loader

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class LoaderComponentImpl(
    componentContext: ComponentContext,
    private val openNextScreen: () -> Unit
) : ComponentContext by componentContext, LoaderComponent {

    private val _model = MutableValue(LoaderComponent.LoaderModel())
    override val model: Value<LoaderComponent.LoaderModel> = _model

    override fun onClick() {
        openNextScreen.invoke()
    }
}