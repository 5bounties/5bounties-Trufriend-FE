package com.vbounties.trufriend.features.presentation.screen.home_screen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState

@Composable
@Preview
fun HomeScreen(
    parentController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<HomeViewModel>()
    val user = remember { mutableStateOf(UserState()) }
    val emotion = remember { mutableStateOf(EmotionState()) }
    viewModel.getUser {
        user.value = it
        viewModel.getEmotionById(user.value.data.id){
            emotion.value = it
        }
    }



    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)) {
            item { Spacer(modifier = Modifier.padding(24.dp)) }
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Card(modifier = Modifier.size(50.dp)){}
                    Card(modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            parentController.navigate(ParentNavigation.Settings.route)
                        }){}
                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item {
                Text(text = "Hello, ${user.value.data.name}", color = Color.Black, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "Lorem ipsum dolor si amet", color = Color.Black, fontWeight = FontWeight.Medium)
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.5f)
                            .padding(vertical = 8.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Perkembangan mood di 7 hari terakhir", fontSize = 12.sp)
                            Text(text = "Senang moderat", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                            Text(text = "Lebih baik daripada minggu sebelumnya", fontSize = 12.sp)
                        }
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(end = 12.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End
                        ){
                            Card(modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)) {

                            }
                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "This week's recommendation!", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            items(3){
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)){

                }
            }

            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "Recent Forums", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item{
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(3){
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(180.dp)) {

                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(64.dp)) }
        }
    }
}