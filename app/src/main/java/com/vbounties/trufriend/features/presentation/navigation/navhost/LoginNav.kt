package com.vbounties.trufriend.features.presentation.navigation.navhost

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.presentation.navigation.`object`.LoginNavigation
import com.vbounties.trufriend.features.presentation.screen.login_screen.LoginScreen
import com.vbounties.trufriend.features.presentation.screen.splash_screen.SplashScreen0
import com.vbounties.trufriend.features.presentation.screen.splash_screen.SplashScreen1
import com.vbounties.trufriend.features.presentation.screen.splash_screen.SplashScreen2
import com.vbounties.trufriend.features.presentation.screen.splash_screen.SplashScreen3

@Composable
@Preview
fun LoginNav(
    parentController: NavController = rememberNavController()
){
    val loginController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()){
        NavHost(navController = loginController, startDestination = LoginNavigation.Splash0.route){
            composable(LoginNavigation.Splash0.route, enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
                )
            }
            ){
                SplashScreen0(loginController)
            }
            composable(LoginNavigation.Splash1.route, enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
                )
            }
            ){
                SplashScreen1(loginController)
            }
            composable(LoginNavigation.Splash2.route, enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
                )
            }
            ){
                SplashScreen2(loginController)
            }
            composable(LoginNavigation.Splash3.route, enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
                )
            }
            ){
                SplashScreen3(loginController)
            }
            composable(LoginNavigation.Login.route, enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
                )
            }
            ){
                LoginScreen(loginController = loginController, parentController = parentController)
            }
        }
    }
}