package com.vbounties.trufriend.features.presentation.navigation.navhost

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.presentation.screen.profile_screen.ProfileScreen
import com.vbounties.trufriend.features.presentation.screen.setting_screen.SettingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParentNav(){
    val parentController = rememberNavController()
    NavHost(navController = parentController, startDestination = ParentNavigation.LoginNav.route){
        composable(route = ParentNavigation.LoginNav.route){
            LoginNav(parentController)
        }
        composable(route = ParentNavigation.BottomNav.route){
            BottomNav(parentController)
        }
        composable(route = ParentNavigation.Profile.route){
            ProfileScreen(parentController)
        }
        composable(route = ParentNavigation.Settings.route){
            SettingScreen(parentController)
        }
    }
}