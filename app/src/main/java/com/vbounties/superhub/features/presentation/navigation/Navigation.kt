package com.vbounties.superhub.features.presentation.navigation

sealed class Navigation(route: String) {
    object Home : Navigation("home")
    object Test : Navigation("test")
}