package com.norm.mywebappkmp.firstscreen

import com.arkivanov.decompose.ComponentContext

interface FirstScreenComponent {
    fun onNavigateToSecondScreen()
}

class DefaultFirstScreenComponent(
    componentContext: ComponentContext,
    private val onShowSecondScreen: () -> Unit,
) : FirstScreenComponent {
    override fun onNavigateToSecondScreen() {
        onShowSecondScreen()
    }
}