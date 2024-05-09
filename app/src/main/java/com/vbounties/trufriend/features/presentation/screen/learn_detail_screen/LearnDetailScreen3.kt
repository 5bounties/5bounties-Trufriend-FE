package com.vbounties.trufriend.features.presentation.screen.learn_detail_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun LearnDetailScreen3(
    bottomController: NavController = rememberNavController()
){
    Scaffold(
        containerColor = Color(0xFFFDF7F0),
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "back", modifier = Modifier.clickable {
                        bottomController.navigate(BottomNavigation.Learn.route)
                    })
                    Text(text = "Kembali", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF7F0))){
                LazyColumn(modifier = Modifier
                    .fillMaxSize()){
                    item {
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp),
                            shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3))
                        ) {
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 32.dp), contentAlignment = Alignment.BottomCenter){
                                Image(painter = painterResource(id = R.drawable.emotionalcontrol), contentDescription = "woman computer", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(16.dp)) }
                    item {
                        Text(text = "Emotional Control", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(text = "Emotional control, atau kontrol emosional, pada individu dengan autisme " +
                                "seringkali merupakan tantangan yang kompleks karena sensitivitas sensorik " +
                                "dan kesulitan dalam memahami dan mengelola emosi. Strategi seperti penggunaan " +
                                "teknik relaksasi, pengaturan sensorik, dan pengajaran keterampilan pemecahan " +
                                "masalah dapat membantu individu dengan autisme mengembangkan kemampuan untuk " +
                                "mengenali, mengekspresikan, dan mengatur emosi mereka secara lebih efektif.", fontSize = 14.sp, modifier = Modifier.padding(horizontal = 16.dp), textAlign = TextAlign.Justify, lineHeight = 20.sp)
                    }
                    item { Spacer(modifier = Modifier.padding(16.dp)) }
                    item {
                        Text(text = "Artikel", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    item{
                        LazyRow(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)) {
                            items(3){
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                                    .padding(end = 16.dp),
                                    colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                                    elevation = CardDefaults.cardElevation(2.dp)
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 16.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(modifier = Modifier
                                            .fillMaxWidth()
                                            .height(80.dp), contentAlignment = Alignment.Center){
                                            Image(painter = painterResource(id = R.drawable.trainingchild), contentDescription = "Training Child", modifier = Modifier.fillMaxSize())
                                        }
                                        Column(modifier = Modifier
                                            .fillMaxWidth()
                                            .height(50.dp)
                                            .padding(horizontal = 16.dp),
                                            verticalArrangement = Arrangement.Bottom
                                        ) {
                                            Text(text = "Training Child's Verbal Ability", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(16.dp)) }
                    item {
                        Text(text = "Video", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    item{
                        LazyRow(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)) {
                            items(3){
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                                    .padding(end = 16.dp),
                                    colors = CardDefaults.cardColors(Color(0xFFF0DAC3)),
                                    elevation = CardDefaults.cardElevation(2.dp)
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 16.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(modifier = Modifier
                                            .fillMaxWidth()
                                            .height(80.dp), contentAlignment = Alignment.Center){
                                            Image(painter = painterResource(id = R.drawable.trainingchild), contentDescription = "Training Child", modifier = Modifier.fillMaxSize())
                                        }
                                        Column(modifier = Modifier
                                            .fillMaxWidth()
                                            .height(50.dp)
                                            .padding(horizontal = 16.dp),
                                            verticalArrangement = Arrangement.Bottom
                                        ) {
                                            Text(text = "Training Child's Verbal Ability", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(72.dp)) }
                }
            }
        }
    )
}