package com.vbounties.trufriend.features.presentation.navigation

sealed class BottomNavigation(val route: String) {
    object Home : BottomNavigation("home")
    object Search : BottomNavigation("search")
    object Learn: BottomNavigation("learn")
    object Forum: BottomNavigation("forum")
    object ForumProfile: BottomNavigation("forumProfile")
    object LearnDetail1 : BottomNavigation("learnDetail1")
    object LearnDetail2 : BottomNavigation("learnDetail2")
    object LearnDetail3 : BottomNavigation("learnDetail3")
    object LearnDetail4 : BottomNavigation("learnDetail4")
    object Yoga: BottomNavigation("yoga")
    object YogaDetails: BottomNavigation("yogaDetails")
    object Tracker : BottomNavigation("tracker")
    object Meditation: BottomNavigation("meditation")
}