package com.vbounties.trufriend.features.presentation.navigation.`object`

import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation

sealed class ParentNavigation(val route: String) {
    object BottomNav : ParentNavigation("bottom")
    object LoginNav : ParentNavigation("login")
    object Test : ParentNavigation("test")
    object LearnDetail : ParentNavigation("learnDetail")
}