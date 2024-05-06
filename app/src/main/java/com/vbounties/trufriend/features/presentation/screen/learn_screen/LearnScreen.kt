package com.vbounties.trufriend.features.presentation.screen.learn_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun LearnScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)){
            item { Spacer(modifier = Modifier.padding(24.dp)) }
            item { Text(text = "Popular smth", fontWeight = FontWeight.SemiBold, fontSize = 24.sp) }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)) {

                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item { Text(text = "Study", fontWeight = FontWeight.SemiBold, fontSize = 20.sp) }
            item {
                LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = Modifier.width(400.dp).height(320.dp), contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                    items(4){
                        Card(modifier = Modifier.size(170.dp)) {

                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item { Text(text = "Meditation", fontWeight = FontWeight.SemiBold, fontSize = 20.sp) }
            items(2){
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)){
                }
            }
            item { 
                Spacer(modifier = Modifier.height(120.dp))
            }
        }
    }
}