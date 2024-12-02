package com.decomposeanimationbug.screens.stuck

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class StuckComponentImpl(
    componentContext: ComponentContext
) : ComponentContext by componentContext, StuckComponent {

    private val _model = MutableValue(StuckComponent.StuckModel())
    override val model: Value<StuckComponent.StuckModel> = _model
}