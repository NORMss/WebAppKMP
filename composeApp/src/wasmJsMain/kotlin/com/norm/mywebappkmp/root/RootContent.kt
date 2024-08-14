package com.norm.mywebappkmp.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.norm.mywebappkmp.firstscreen.FirstScreen
import com.norm.mywebappkmp.secondscreen.SecondScreen

@Composable
internal fun RootContent(
    component: RootComponent
) {
    MaterialTheme {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.FirstScreen -> FirstScreen(component = instance.component)
                is RootComponent.Child.SecondScreen -> SecondScreen(component = instance.component)
            }
        }
    }
}