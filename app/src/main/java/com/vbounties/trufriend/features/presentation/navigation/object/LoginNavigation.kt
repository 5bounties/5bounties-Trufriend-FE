package com.vbounties.trufriend.features.presentation.navigation.`object`

sealed class LoginNavigation(val route: String) {
    object Splash0 : LoginNavigation("splash0")
    object Splash1 : LoginNavigation("splash1")
    object Splash2 : LoginNavigation("splash2")
    object Splash3 : LoginNavigation("splash3")
    object Splash4 : LoginNavigation("splash4")
    object Login : LoginNavigation("login")
    object SignIn : LoginNavigation("signin")
}