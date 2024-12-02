package com.decomposeanimationbug.screens.list

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.value.Value

@Immutable
interface ListComponent {

    val model: Value<ListModel>

    class ListModel
}