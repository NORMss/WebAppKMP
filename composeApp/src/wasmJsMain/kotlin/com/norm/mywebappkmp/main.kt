package com.norm.mywebappkmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.norm.mywebappkmp.root.DefaultRootComponent
import com.norm.mywebappkmp.root.RootContent

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    val root = DefaultRootComponent(
        componentContext = DefaultComponentContext(lifecycle = lifecycle)
    )

    lifecycle.resume()

    CanvasBasedWindow(
        canvasElementId = "MyWebAppKMP",
    ) {
        RootContent(root)
    }
}