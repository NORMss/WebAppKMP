package com.norm.mywebappkmp.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.norm.mywebappkmp.firstscreen.DefaultFirstScreenComponent
import com.norm.mywebappkmp.firstscreen.FirstScreenComponent
import com.norm.mywebappkmp.secondscreen.DefaultSecondScreenComponent
import com.norm.mywebappkmp.secondscreen.SecondScreenComponent

internal class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = null,
            initialConfiguration = Config.FirstScreen,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(
        config: Config,
        childComponentContext: ComponentContext
    ): RootComponent.Child =
        when (config) {
            is Config.FirstScreen -> RootComponent.Child.FirstScreen(
                firstScreenComponent(
                    childComponentContext
                )
            )

            is Config.SecondScreen -> RootComponent.Child.SecondScreen(
                secondScreenComponent(
                    childComponentContext
                )
            )
        }

    private fun firstScreenComponent(componentContext: ComponentContext): FirstScreenComponent =
        DefaultFirstScreenComponent(
            componentContext = componentContext,
            onShowSecondScreen = { navigation.push(Config.SecondScreen) },
        )

    private fun secondScreenComponent(componentContext: ComponentContext): SecondScreenComponent =
        DefaultSecondScreenComponent(
            componentContext = componentContext,
            onBack = navigation::pop,
        )

    override fun onBack(index: Int) {
        navigation.popTo(index = index)
    }

    private sealed interface Config {
        data object FirstScreen : Config
        data object SecondScreen : Config
    }
}