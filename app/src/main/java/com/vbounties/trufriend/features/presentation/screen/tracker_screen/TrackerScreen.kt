package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun TrackerScreen(){
    val isClicked = remember { mutableStateOf(false) }
    Scaffold(
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Card(modifier = Modifier.size(50.dp)){}
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "3rd Week of May, 2024", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(32.dp))
                    LazyRow(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)) {
                        items(4){
                            Spacer(modifier = Modifier.width(50.dp))
                            CalendarWidget()
                            Spacer(modifier = Modifier.width(50.dp))
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
                    .clip(CircleShape)) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            isClicked.value = !isClicked.value
                        }, contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = "add", modifier = Modifier.size(50.dp))
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}