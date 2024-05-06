package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun OrbitWidget(){
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 90.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)){}
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 30.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)){}
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)){}
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 30.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)){}
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 90.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)){}
        }
    }
}