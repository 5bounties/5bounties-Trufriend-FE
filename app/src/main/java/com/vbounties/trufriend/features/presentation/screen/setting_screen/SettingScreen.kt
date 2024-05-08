package com.vbounties.trufriend.features.presentation.screen.setting_screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.PersonOutline
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SettingScreen(
    parentController: NavController = rememberNavController()
){
    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
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
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "back", modifier = Modifier.clickable {
                        parentController.navigate(ParentNavigation.BottomNav.route)
                    })
                    Text(text = "Kembali", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp)){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Pengaturan", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp),
                        colors = CardDefaults.cardColors(Color(0xFFF9E5D0)),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(50.dp)).clickable {
                                    parentController.navigate(ParentNavigation.Profile.route)
                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painter = painterResource(id = R.drawable.user), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Akun dan Keamanan", fontSize = 16.sp)
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp).clip(RoundedCornerShape(50.dp)).clickable {

                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painterResource(id = R.drawable.notification ), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Notifikasi", fontSize = 16.sp)
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp).clip(RoundedCornerShape(50.dp)).clickable {

                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painterResource(id = R.drawable.bahasa), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Bahasa Aplikasi", fontSize = 16.sp)
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp).clip(RoundedCornerShape(50.dp)).clickable {

                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painterResource(id = R.drawable.question), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Pertanyaan Sering Muncul", fontSize = 16.sp)
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp).clip(RoundedCornerShape(50.dp)).clickable {

                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painterResource(id = R.drawable.bantuan), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Bantuan dan Dukungan", fontSize = 16.sp)
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp).clip(RoundedCornerShape(50.dp)).clickable {

                                }, verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center){
                                    Icon(painterResource(id = R.drawable.ketentuan), contentDescription = "account", modifier = Modifier.fillMaxSize(0.6f))
                                }
                                Text(text = "Ketentuan dan kebijakan", fontSize = 16.sp)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(92.dp))
                    Card(modifier = Modifier
                        .height(48.dp)
                        .width(200.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color(0xFFFFB764)),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Keluar Akun", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    )
}