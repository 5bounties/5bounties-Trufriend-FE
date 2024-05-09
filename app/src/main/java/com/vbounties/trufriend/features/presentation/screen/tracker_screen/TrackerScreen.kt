package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun TrackerScreen(){
    val isClicked = remember { mutableStateOf(false) }
    Scaffold(
        containerColor = Color(0xFFFDF7F0),
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF7F0))){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(72.dp))
                    Text(text = "Catatan Moodmu :)", fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color.Black),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Rounded.Search, contentDescription = "email", tint = Color.Gray)
                            Spacer(modifier = Modifier.width(8.dp))
                            BasicTextField(value = "Apa yang ingin kamu cari..?", onValueChange = {

                            }, modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 16.dp),
                                textStyle = TextStyle(color = Color.Gray)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    LazyRow(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)) {
                        items(4){
                            JournalCard()
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 32.dp),
                contentAlignment = Alignment.Center
            ){
                if(isClicked.value){
                    OrbitWidget()
                }
                Card(modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                    colors = CardDefaults.cardColors(Color(0xFFFAE6D1))
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            isClicked.value = !isClicked.value
                        }, contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = "add", modifier = Modifier.size(50.dp), tint = Color(0xFFC36528))
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}