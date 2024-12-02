package com.decomposeanimationbug.screens.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListComponentImpl(
    componentContext: ComponentContext,
    private val openStuck: () -> Unit
) : ComponentContext by componentContext, ListComponent {

    private val _model = MutableValue(ListComponent.ListModel())
    override val model: Value<ListComponent.ListModel> = _model

    private val scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    init {
        scope.launch {
            delay(10)
            openStuck.invoke()
        }
    }

}