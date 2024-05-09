package com.vbounties.trufriend.features.presentation.navigation.navhost

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation
import com.vbounties.trufriend.features.presentation.screen.forum_screen.ForumProfile
import com.vbounties.trufriend.features.presentation.screen.forum_screen.ForumScreen
import com.vbounties.trufriend.features.presentation.screen.home_screen.HomeScreen
import com.vbounties.trufriend.features.presentation.screen.learn_detail_screen.LearnDetailScreen1
import com.vbounties.trufriend.features.presentation.screen.learn_detail_screen.LearnDetailScreen2
import com.vbounties.trufriend.features.presentation.screen.learn_detail_screen.LearnDetailScreen3
import com.vbounties.trufriend.features.presentation.screen.learn_detail_screen.LearnDetailScreen4
import com.vbounties.trufriend.features.presentation.screen.learn_detail_screen.LearnDetailScreen5
import com.vbounties.trufriend.features.presentation.screen.learn_screen.LearnScreen
import com.vbounties.trufriend.features.presentation.screen.meditation_screen.MeditationScreen
import com.vbounties.trufriend.features.presentation.screen.search_screen.SearchScreen
import com.vbounties.trufriend.features.presentation.screen.tracker_screen.TrackerScreen
import com.vbounties.trufriend.features.presentation.screen.yoga_screen.YogaDetails
import com.vbounties.trufriend.features.presentation.screen.yoga_screen.YogaScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
//@Preview
fun BottomNav(parentController: NavController = rememberNavController()){
    val bottomController = rememberNavController()
    val selected = remember { mutableStateOf(0) }
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
                    HomeScreen(parentController, bottomController){
                        selected.value = it
                    }
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
                    LearnScreen(bottomController)
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
                    MeditationScreen(bottomController)
                }

                composable(BottomNavigation.LearnDetail1.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnDetailScreen1(bottomController)
                }
                composable(BottomNavigation.LearnDetail2.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnDetailScreen2(bottomController)
                }

                composable(BottomNavigation.LearnDetail3.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnDetailScreen3(bottomController)
                }

                composable(BottomNavigation.LearnDetail4.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnDetailScreen4(bottomController)
                }

                composable(BottomNavigation.LearnDetail5.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    LearnDetailScreen5(bottomController)
                }

                composable(BottomNavigation.Yoga.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    YogaScreen(bottomController)
                }

                composable(BottomNavigation.Forum.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    ForumScreen(parentController = parentController, bottomController = bottomController)
                }

                composable(BottomNavigation.YogaDetails.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    YogaDetails(bottomController = bottomController)
                }

                composable(BottomNavigation.ForumProfile.route, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
                ){
                    ForumProfile(bottomController)
                }
            }
        },
        bottomBar = {
            BottomNavBar(bottomController, selected.value){
                selected.value = it
            }
        }
    )
}

@Composable
fun BottomNavBar(bottomController: NavController = rememberNavController(), selected: Int = 0, onSelected: (Int) -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color(0xFFFCEEE0)),
        shape = RectangleShape
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 4.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    bottomController.navigate(BottomNavigation.Home.route)
                    onSelected(0)
                }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){

                    Icon(painter = painterResource(id = R.drawable.home), contentDescription = "edhub", modifier = Modifier.fillMaxSize(0.7f), tint = if(selected == 0){
                        Color(0xFFC36528)
                    } else{
                        Color.Gray
                    }
                    )
                }
                Text(text = "Home", modifier = Modifier, color = if(selected == 0){
                    Color(0xFFC36528)
                } else{
                    Color.Gray
                }, fontSize = 12.sp)
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    bottomController.navigate(BottomNavigation.Learn.route)
                    onSelected(1)
                }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){

                    Icon(painter = painterResource(id = R.drawable.edhub), contentDescription = "edhub", modifier = Modifier.fillMaxSize(0.7f), tint = if(selected == 1){
                        Color(0xFFC36528)
                    } else{
                        Color.Gray
                    })
                }
                Text(text = "EdHub", modifier = Modifier, color = if(selected == 1){
                    Color(0xFFC36528)
                } else{
                    Color.Gray
                }, fontSize = 12.sp)
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    bottomController.navigate(BottomNavigation.Tracker.route)
                    onSelected(2)
                }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){

                    Icon(painter = painterResource(id = R.drawable.newjournal), contentDescription = "edhub", modifier = Modifier.fillMaxSize(0.7f), tint = if(selected == 2){
                        Color(0xFFC36528)
                    } else{
                        Color.Gray
                    })
                }

                Text(text = "Journal", modifier = Modifier, color = if(selected == 2){
                    Color(0xFFC36528)
                } else{
                    Color.Gray
                }, fontSize = 12.sp)
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    bottomController.navigate(BottomNavigation.Forum.route)
                    onSelected(3)
                }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){
                    Icon(painter = painterResource(id = R.drawable.forum), contentDescription = "edhub", modifier = Modifier.fillMaxSize(0.7f), tint = if(selected == 3){
                        Color(0xFFC36528)
                    } else{
                        Color.Gray
                    })
                }

                Text(text = "Forum", modifier = Modifier, color = if(selected == 3){
                    Color(0xFFC36528)
                } else{
                    Color.Gray
                }, fontSize = 12.sp)
            }
        }
    }
}