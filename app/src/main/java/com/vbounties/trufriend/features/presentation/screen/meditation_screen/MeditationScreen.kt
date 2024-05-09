package com.vbounties.trufriend.features.presentation.screen.meditation_screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
fun MeditationScreen(
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
                    Text(text = "Meditation", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        content = {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
                item{
                    Spacer(modifier = Modifier.height(80.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(id = R.drawable.vinyl), contentDescription = "player", modifier = Modifier.scale(0.8f))
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item{
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column{
                            Text(text = "Autism Calming Sensory Meltdown\nRemedy Soothing Visuals", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Various Artists", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "1:00:00", color = Color.Gray, fontSize = 12.sp)
                        }

                        Card(modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                            colors = CardDefaults.cardColors(Color(0xFFDB9C57)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {

                            }, contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "play", modifier = Modifier.size(50.dp), tint = Color(0xFFFAE6D1))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(36.dp))
                }

                item{
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column{
                            Text(text = "Autism Calming Sensory:" +
                                    " Relaxing \nMusic", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Various Artists", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "1:00:00", color = Color.Gray, fontSize = 12.sp)
                        }

                        Card(modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                            colors = CardDefaults.cardColors(Color(0xFFDB9C57)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {

                            }, contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "play", modifier = Modifier.size(50.dp), tint = Color(0xFFFAE6D1))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(36.dp))
                }

                item{
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column{
                            Text(text = "Best Sensory Music for Autism \nSensory", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Various Artists", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "1:00:00", color = Color.Gray, fontSize = 12.sp)
                        }

                        Card(modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                            colors = CardDefaults.cardColors(Color(0xFFDB9C57)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {

                            }, contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "play", modifier = Modifier.size(50.dp), tint = Color(0xFFFAE6D1))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(36.dp))
                }

                item{
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column{
                            Text(text = "Instant Stress and Anxiety Relief, \nNegative Emotion Detox", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Various Artists", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "1:00:00", color = Color.Gray, fontSize = 12.sp)
                        }

                        Card(modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                            colors = CardDefaults.cardColors(Color(0xFFDB9C57)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {

                            }, contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "play", modifier = Modifier.size(50.dp), tint = Color(0xFFFAE6D1))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(36.dp))
                }
                item {
                    Spacer(modifier = Modifier.height(180.dp))
                }
            }
        }
    )
}