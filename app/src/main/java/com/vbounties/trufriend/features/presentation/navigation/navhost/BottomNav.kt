package com.vbounties.trufriend.features.presentation.navigation.navhost

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation
import com.vbounties.trufriend.features.presentation.screen.home_screen.HomeScreen
import com.vbounties.trufriend.features.presentation.screen.learn_screen.LearnScreen
import com.vbounties.trufriend.features.presentation.screen.meditation_screen.MeditationScreen
import com.vbounties.trufriend.features.presentation.screen.search_screen.SearchScreen
import com.vbounties.trufriend.features.presentation.screen.tracker_screen.TrackerScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun BottomNav(parentController: NavController = rememberNavController()){
    val bottomController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            NavHost(navController = bottomController, startDestination = BottomNavigation.Home.route){
                composable(BottomNavigation.Home.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    HomeScreen(parentController)
                }

                composable(BottomNavigation.Search.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    SearchScreen()
                }

                composable(BottomNavigation.Learn.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnScreen()
                }

                composable(BottomNavigation.Tracker.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    TrackerScreen()
                }

                composable(BottomNavigation.Meditation.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    MeditationScreen()
                }
            }
        },
        bottomBar = {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
                elevation = CardDefaults.cardElevation(32.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Home", modifier = Modifier.clickable { bottomController.navigate(BottomNavigation.Home.route) })
                    Text(text = "Search", modifier = Modifier.clickable { bottomController.navigate(BottomNavigation.Search.route) })
                    Text(text = "Learn", modifier = Modifier.clickable { bottomController.navigate(BottomNavigation.Learn.route) })
                    Text(text = "Tracker", modifier = Modifier.clickable { bottomController.navigate(BottomNavigation.Tracker.route) })
                    Text(text = "Meditation", modifier = Modifier.clickable { bottomController.navigate(BottomNavigation.Meditation.route) })
                }
            }
        }
    )
}