package com.vbounties.trufriend.features.presentation.screen.splash_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.design_system.TrufriendPurple
import com.vbounties.trufriend.features.presentation.navigation.`object`.LoginNavigation
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SplashScreen2(
    loginController: NavController = rememberNavController()
){
    LaunchedEffect(key1 = true){
        delay(8000)
        loginController.navigate(LoginNavigation.Splash3.route)
    }

    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize().padding(bottom = 72.dp), contentAlignment = Alignment.Center){
                Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                    Image(painter = painterResource(id = R.drawable.splashscreen2), contentDescription = "splash")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Optimalkan potensi anda dengan Academate.", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Jelajahi beasiswa, bootcamp, lomba, dan webinar yang sesuai dengan minat anda", fontWeight = FontWeight.Medium)
                }
            }
        },
        bottomBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 48.dp), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.singledot2), contentDescription = "singledot", modifier = Modifier.scale(0.8f))
                Card(modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                    colors = CardDefaults.cardColors(TrufriendPurple)
                ){
                    Box(modifier = Modifier.fillMaxSize().clickable {
                                                                    loginController.navigate(LoginNavigation.Splash3.route)
                    }, contentAlignment = Alignment.Center){
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = "next", tint = Color.White, modifier = Modifier.size(30.dp))
                    }
                }
            }
        }
    )
}