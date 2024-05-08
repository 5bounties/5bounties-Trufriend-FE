package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun JournalCard(

){
    Card(
        modifier = Modifier
            .width(360.dp)
            .height(200.dp)
            ,
        colors = CardDefaults.cardColors(Color(0xFFF9E5D0))
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.size(60.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(0xFFFEB664)),
                border = BorderStroke(2.dp, color = Color(0xFFFEB664))
                ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Icon(imageVector = Icons.Rounded.PersonOutline, contentDescription = "profile")
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(text = "Nathan", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = "6 Mei 2024", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp)) {
            Text(text = "Today alfredo is feeling sad yid...", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.padding(6.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "--4.40 PM--",  fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

    }
}