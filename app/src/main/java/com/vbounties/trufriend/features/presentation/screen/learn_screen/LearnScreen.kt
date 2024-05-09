package com.vbounties.trufriend.features.presentation.screen.learn_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation

@Composable
@Preview
fun LearnScreen(
    bottomController: NavController = rememberNavController()
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFDF7F0))){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)){
            item { Spacer(modifier = Modifier.padding(24.dp)) }
            item { Text(text = "Konten Populer", fontWeight = FontWeight.SemiBold, fontSize = 24.sp) }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 16.dp),
                    colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp), verticalArrangement = Arrangement.Bottom) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.trainingchild), contentDescription = "Training Child")
                        }
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(text = "Training Child's Verbal Ability", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item { Text(text = "Kategori", fontWeight = FontWeight.SemiBold, fontSize = 20.sp) }
            item {
                LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = Modifier
                    .width(400.dp)
                    .height(340.dp), contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                    item{
                        Card(modifier = Modifier.size(170.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {
                                                                            bottomController.navigate(BottomNavigation.LearnDetail1.route)
                            }, contentAlignment = Alignment.BottomCenter){
                                Image(painter = painterResource(id = R.drawable.verbalskills), contentDescription = "verbalskills", modifier = Modifier.padding(top = 42.dp).fillMaxSize(), contentScale = ContentScale.Crop)
                                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                                    Text(text = "Verbal \nSkills", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                }
                            }
                        }
                    }

                    item {
                        Card(modifier = Modifier.size(170.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {
                                bottomController.navigate(BottomNavigation.LearnDetail2.route)
                            }, contentAlignment = Alignment.BottomCenter){
                                Image(painter = painterResource(id = R.drawable.socialskills), contentDescription = "verbalskills", modifier = Modifier.padding(top = 42.dp).fillMaxSize(), contentScale = ContentScale.Crop)
                                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                                    Text(text = "Social Skills", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                }
                            }
                        }
                    }

                    item {
                        Card(modifier = Modifier.size(170.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {
                                bottomController.navigate(BottomNavigation.LearnDetail3.route)
                            }, contentAlignment = Alignment.BottomCenter){
                                Image(painter = painterResource(id = R.drawable.emotionalcontrol), contentDescription = "verbalskills", modifier = Modifier.padding(top = 42.dp).fillMaxSize(), contentScale = ContentScale.Crop)
                                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                                    Text(text = "Emotional Control", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                }
                            }
                        }
                    }

                    item {
                        Card(modifier = Modifier.size(170.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize().clickable {
                                bottomController.navigate(BottomNavigation.LearnDetail4.route)
                            }, contentAlignment = Alignment.BottomCenter){
                                Image(painter = painterResource(id = R.drawable.motoricskills), contentDescription = "verbalskills", modifier = Modifier.padding(top = 42.dp).fillMaxSize(), contentScale = ContentScale.Crop)
                                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                                    Text(text = "Sensoric & Motoric Skills", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                }
                            }
                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item { Text(text = "Meditasi", fontWeight = FontWeight.SemiBold, fontSize = 20.sp) }
            item{
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFAE6D1)),
                    elevation = CardDefaults.cardElevation(2.dp)
                ){
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp).clickable {
                            bottomController.navigate(BottomNavigation.Yoga.route)
                        }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(id = R.drawable.yoga), contentDescription = "mood", modifier = Modifier.fillMaxHeight())
                        Spacer(modifier = Modifier.padding(16.dp))
                        Column(modifier = Modifier) {
                            Text(text = "Yoga for Autism", fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                        }
                    }
                }
            }

            item{
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFAE6D1)),
                    elevation = CardDefaults.cardElevation(2.dp)
                ){
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp).clickable {
                                 bottomController.navigate(BottomNavigation.Meditation.route)
                        }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(id = R.drawable.musictherapy), contentDescription = "mood", modifier = Modifier.fillMaxHeight())
                        Spacer(modifier = Modifier.padding(16.dp))
                        Column(modifier = Modifier) {
                            Text(text = "Music Therapy", fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                        }
                    }
                }
            }

            item { 
                Spacer(modifier = Modifier.height(120.dp))
            }
        }
    }
}