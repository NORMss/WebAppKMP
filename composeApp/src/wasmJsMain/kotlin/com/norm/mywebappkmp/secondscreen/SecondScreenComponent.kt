package com.norm.mywebappkmp.secondscreen

import com.arkivanov.decompose.ComponentContext

interface SecondScreenComponent {
    fun onNavigateToFirstScreen()
}

class DefaultSecondScreenComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : SecondScreenComponent, ComponentContext by componentContext {
    override fun onNavigateToFirstScreen() {
        onNavigateToFirstScreen()
    }
}