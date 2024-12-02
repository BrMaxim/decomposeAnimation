package com.decomposeanimationbug.screens.stuck

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.value.Value

@Immutable
interface StuckComponent {

    val model: Value<StuckModel>

    class StuckModel
}