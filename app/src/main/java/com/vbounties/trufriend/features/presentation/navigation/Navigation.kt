package com.vbounties.trufriend.features.presentation.navigation

sealed class Navigation(route: String) {
    object Home : Navigation("home")
    object Learn: Navigation("learn")
    object LearnDetail : Navigation("learnDetail")
    object Tracker : Navigation("tracker")
    object Test : Navigation("test")
}