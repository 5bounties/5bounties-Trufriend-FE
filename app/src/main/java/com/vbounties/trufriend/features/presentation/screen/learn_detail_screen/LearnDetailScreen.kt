package com.vbounties.trufriend.features.presentation.screen.learn_detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vbounties.trufriend.R

@Composable
@Preview
fun LearnDetailScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()){
            item {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                    shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                    ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp, start = 16.dp, end = 16.dp), contentAlignment = Alignment.BottomCenter){
                        Image(painter = painterResource(id = R.drawable.womancomputer), contentDescription = "woman computer")
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "Title", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "Lorem ipsum dolor sit amet, pada suatu hari ada seekor anjing yang sedang berjalan di tepi taman. Anjing tersebut terlihat sangat senang sekali.", fontSize = 14.sp, modifier = Modifier.padding(horizontal = 16.dp))
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "Articles", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.padding(4.dp))
            }
            item{
                LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                    items(3){
                        Card(modifier = Modifier.height(100.dp).width(220.dp)) {

                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "Videos", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.padding(4.dp))
            }
            item{
                LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                    items(3){
                        Card(modifier = Modifier.height(100.dp).width(220.dp)) {

                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}