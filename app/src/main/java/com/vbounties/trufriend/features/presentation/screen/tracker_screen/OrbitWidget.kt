package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.domain.model.EmotionModel
import com.vbounties.trufriend.features.domain.model.EmotionType

@Composable
fun OrbitWidget(
    onClick: (EmotionModel) -> Unit
){
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 90.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape).clickable {
                    onClick(EmotionType.DATAR)
                }){
                Image(painter = painterResource(id = R.drawable.mood1), contentDescription = "mood 1", modifier = Modifier.fillMaxSize())
            }
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 30.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape).clickable {
                    onClick(EmotionType.SEDIH)
                }){
                Image(painter = painterResource(id = R.drawable.mood2), contentDescription = "mood 2", modifier = Modifier.fillMaxSize())
            }
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape).clickable {
                    onClick(EmotionType.BAHAGIA)
                }){
                Image(painter = painterResource(id = R.drawable.mood3), contentDescription = "mood 1", modifier = Modifier.fillMaxSize())
            }
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 30.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape).clickable {
                    onClick(EmotionType.CEMAS)
                }){
                Image(painter = painterResource(id = R.drawable.mood4), contentDescription = "mood 1", modifier = Modifier.fillMaxSize())
            }
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(top = 90.dp)) {
            Card(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape).clickable {
                    onClick(EmotionType.MARAH)
                }
            ){
                Image(painter = painterResource(id = R.drawable.mood5), contentDescription = "mood 1", modifier = Modifier.fillMaxSize())
            }
        }
    }
}