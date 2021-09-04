package com.daniel.farage.composeinitiation.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailsScreen: Screen("details_screen")
    object SplashScreen: Screen("splash_screen")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }

}
