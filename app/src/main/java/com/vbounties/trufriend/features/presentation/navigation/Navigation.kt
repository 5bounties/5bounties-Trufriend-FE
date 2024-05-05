package com.vbounties.trufriend.features.presentation.navigation

sealed class Navigation(route: String) {
    object Home : Navigation("home")
    object Test : Navigation("test")
}