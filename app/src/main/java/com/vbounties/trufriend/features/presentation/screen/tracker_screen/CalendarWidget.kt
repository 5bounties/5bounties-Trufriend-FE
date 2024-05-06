package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun CalendarWidget(){
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.width(260.dp).height(300.dp)) {
        items(7){
            DayWidget()
        }
    }
}

@Composable
@Preview
fun DayWidget(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sun")
        Spacer(modifier = Modifier.padding(4.dp))
        Card(modifier = Modifier.size(60.dp)){}
    }
}