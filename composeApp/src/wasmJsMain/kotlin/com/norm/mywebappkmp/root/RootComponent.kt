package com.norm.mywebappkmp.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.norm.mywebappkmp.firstscreen.FirstScreenComponent
import com.norm.mywebappkmp.secondscreen.SecondScreenComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onBack(index: Int)

    sealed class Child {
        data class FirstScreen(val component: FirstScreenComponent) : Child()
        data class SecondScreen(val component: SecondScreenComponent) : Child()
    }
}