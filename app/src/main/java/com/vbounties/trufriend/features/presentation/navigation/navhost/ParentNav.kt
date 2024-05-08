package com.vbounties.trufriend.features.presentation.navigation.navhost

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.presentation.screen.home_screen.HomeViewModel
import com.vbounties.trufriend.features.presentation.screen.profile_screen.ProfileScreen
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState
import com.vbounties.trufriend.features.presentation.screen.setting_screen.SettingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParentNav(){
    val viewModel = hiltViewModel<HomeViewModel>()
    val user = remember { mutableStateOf(UserState()) }

    viewModel.getUser {
        user.value = it
    }

    val parentController = rememberNavController()
    NavHost(navController = parentController, startDestination = if(user.value.data.name.equals("dummy")){
        ParentNavigation.LoginNav.route
    } else {
        ParentNavigation.BottomNav.route
    }

    ){
        composable(route = ParentNavigation.LoginNav.route, enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
            )
        }, popExitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
            )
        }
        ){
            LoginNav(parentController)
        }

        composable(route = ParentNavigation.BottomNav.route, enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
            )
        }, popExitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
            )
        }
        ){
            BottomNav(parentController)
        }

        composable(route = ParentNavigation.Profile.route, enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
            )
        }, popExitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
            )
        }
        ){
            ProfileScreen(parentController)
        }

        composable(route = ParentNavigation.Settings.route, enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
            )
        }, popExitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
            )
        }
        ){
            SettingScreen(parentController)
        }
    }
}