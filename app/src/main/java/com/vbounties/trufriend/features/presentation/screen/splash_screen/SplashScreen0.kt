package com.vbounties.trufriend.features.presentation.screen.splash_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.vbounties.trufriend.features.presentation.design_system.TrufriendYellow
import com.vbounties.trufriend.features.presentation.navigation.`object`.LoginNavigation
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SplashScreen0(
    loginController: NavController = rememberNavController()
){
    LaunchedEffect(key1 = true){
        delay(3000)
        loginController.navigate(LoginNavigation.Splash1.route)
    }

    Scaffold(
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = Alignment.Center
            ){
                Box(modifier = Modifier.size(120.dp)) {
                    Image(painter = painterResource(id = R.drawable.logoxl), contentDescription = "logo")
                }
            }
        },
        bottomBar = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 72.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
                ) {
                CircularProgressIndicator(color = Color(0xFFFFB764))
                Spacer(modifier = Modifier.height(72.dp))
                Text(text = "Created by", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color(0xFFC36528))
                Text(text = "5bounties", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color(0xFF458956))
            }
        }
    )

}