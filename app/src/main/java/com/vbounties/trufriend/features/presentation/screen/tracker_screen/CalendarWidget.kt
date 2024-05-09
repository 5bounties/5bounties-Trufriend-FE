package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.domain.model.EmotionModel
import com.vbounties.trufriend.features.domain.model.EmotionType

@Composable
@Preview
fun CalendarWidget(){
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier
        .width(260.dp)
        .height(300.dp)) {
        items(7){
            DayWidget(day = days[it])
        }
    }
}

@Composable
@Preview
fun DayWidget(day: String = "Mon", emotionModel: EmotionModel = EmotionType.DATAR){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = day)
        Spacer(modifier = Modifier.padding(4.dp))
        Card(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)){
            Image(painter = painterResource(id = emotionModel.resource), contentDescription = "mood", modifier = Modifier.fillMaxSize())
        }
    }
}