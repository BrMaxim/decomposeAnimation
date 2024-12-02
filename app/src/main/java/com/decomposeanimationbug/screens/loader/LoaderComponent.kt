package com.decomposeanimationbug.screens.loader

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.value.Value

@Immutable
interface LoaderComponent {

    val model: Value<LoaderModel>

    fun onClick()

    class LoaderModel
}