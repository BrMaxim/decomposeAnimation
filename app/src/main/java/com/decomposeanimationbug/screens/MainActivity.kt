package com.decomposeanimationbug.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.decomposeanimationbug.screens.root.RootFactory
import com.decomposeanimationbug.screens.root.RootScreen
import com.decomposeanimationbug.ui.theme.DecomposeAnimationBugTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val rootFactory: RootFactory by inject()
    private val rootComponent by lazy { rootFactory.create(defaultComponentContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecomposeAnimationBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootScreen(
                        modifier = Modifier.padding(innerPadding),
                        component = rootComponent
                    )
                }
            }
        }
    }
}