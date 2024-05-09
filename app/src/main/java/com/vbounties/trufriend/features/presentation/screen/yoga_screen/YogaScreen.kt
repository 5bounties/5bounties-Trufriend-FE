package com.vbounties.trufriend.features.presentation.screen.yoga_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun YogaScreen(
    bottomController: NavController = rememberNavController()
){
    Scaffold(
        containerColor = Color(0xFFFDF7F0),
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "back", modifier = Modifier.clickable {
                        bottomController.navigate(BottomNavigation.Learn.route)
                    })
                    Text(text = "Yoga Playlist", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        content = {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
                item {
                    Spacer(modifier = Modifier.height(92.dp))
                }
                items(4){
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp).clickable {
                            bottomController.navigate(BottomNavigation.YogaDetails.route)
                        }.clip(RoundedCornerShape(8.dp)),
                        colors = CardDefaults.cardColors(Color(0xFFFAE6D1))
                    ) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 60.dp, bottom = 8.dp), contentAlignment = Alignment.BottomCenter){
                            Image(painter = painterResource(id = R.drawable.yoga2), contentDescription = "yoga", modifier = Modifier.fillMaxWidth())
                        }
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Easy Yoga Session", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Card(modifier = Modifier.size(30.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(Color(0xFFFEB664)),
                            border = BorderStroke(2.dp, color = Color(0xFFFEB664))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.PersonOutline, contentDescription = "profile")
                            }
                        }
                        Spacer(modifier = Modifier.padding(6.dp))
                        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                    
                    Spacer(modifier = Modifier.padding(16.dp))
                }
                
                item {
                    Spacer(modifier = Modifier.height(72.dp))
                }
            }
        }
    )

}