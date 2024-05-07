package com.vbounties.trufriend.features.presentation.screen.search_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SearchScreen(){
    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 24.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "back")
                    Text(text = "Search", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        content = {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
                item {
                    Spacer(modifier = Modifier.height(90.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        items(4){
                            Card(modifier = Modifier
                                .width(100.dp)
                                .height(40.dp),
                                shape = RoundedCornerShape(50.dp)
                            ){

                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            }
        },
    )
}