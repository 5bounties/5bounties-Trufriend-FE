package com.vbounties.trufriend.features.presentation.screen.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.data.remote.response.JournalData2
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState

@Composable
@Preview
fun HomeScreen(
    parentController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<HomeViewModel>()
    val user = remember { mutableStateOf(UserState()) }
    val journal = remember { mutableStateOf(JournalState()) }
    val userAvatar = remember{ mutableStateOf("") }
    viewModel.getUser {
        user.value = it
        userAvatar.value = "https://uitrssskfwjwscymocmu.supabase.co/storage/v1/object/public/avatar/" + it.data.avatarUrl.substringAfterLast("/")
    }
    val context = LocalContext.current

    viewModel.getJournal {
        journal.value = it
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFDF7F0))){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)) {
            item { Spacer(modifier = Modifier.padding(24.dp)) }
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Card(modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            parentController.navigate(ParentNavigation.Settings.route)
                        },
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(Color(0xFFFFB764)),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ){
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(id = R.drawable.user), contentDescription = "user", tint = Color.White, modifier = Modifier.fillMaxSize(0.5f))
                            AsyncImage(model = userAvatar.value, contentDescription = "avatar", imageLoader = ImageLoader(context), modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Card(modifier = Modifier
                            .width(50.dp)
                            .height(36.dp),
                            colors = CardDefaults.cardColors(Color.White),
                            border = BorderStroke(1.dp, Color.Gray)
                        ){
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Icon(painter = painterResource(id = R.drawable.notification), contentDescription = "user", tint = Color(0xFFFFB764), modifier = Modifier.fillMaxSize(0.6f))
                            }
                        }
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "Notifikasi", fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(8.dp)) }
            item {
                Text(text = "Hello, ${user.value.data.name}", color = Color.Black, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "Terus semangat jalani harimu!", color = Color.Black, fontWeight = FontWeight.Medium)
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                LazyRow() {
                    items(journal.value.data.data.filter { it.userId.equals(user.value.data.id) }){
                        Card(
                            modifier = Modifier
                                .width(360.dp)
                                .height(160.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFAE6D1)),
                            elevation = CardDefaults.cardElevation(2.dp)
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
                                    Text(text = "Perkembangan mood kamu baru-baru ini..", fontSize = 12.sp, lineHeight = 16.sp)
                                    Text(text = it.mood, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                                    Text(text = it.content, fontSize = 12.sp)
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
                                        Image(painter = painterResource(id = when(it.mood){
                                            "FINE" -> { R.drawable.mood1 }
                                            "SAD" -> { R.drawable.mood2 }
                                            "AWESOME" -> { R.drawable.mood3 }
                                            "WORRIED" -> { R.drawable.mood4 }
                                            "ANGRY" -> { R.drawable.mood5 }
                                            else -> { R.drawable.mood1 }
                                        }
                                        ), contentDescription = "mood", modifier = Modifier.fillMaxSize())
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.padding(16.dp))
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item {
                Text(text = "Rekomendasi minggu ini!", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            items(3){
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFAE6D1)),
                    elevation = CardDefaults.cardElevation(2.dp)
                ){
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.friends), contentDescription = "mood", modifier = Modifier.fillMaxHeight())
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(modifier = Modifier) {
                            Text(text = "Teach Children with Autism", fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Dr. Mary Barbera", fontSize = 14.sp, color = Color.Gray)
                        }
                    }
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
                            .height(220.dp)
                            .width(280.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFAE6D1)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                Card(modifier = Modifier.size(30.dp),
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
                                    Text(text = "@dewangga", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                    Spacer(modifier = Modifier.padding(2.dp))
                                    Text(text = "Artist", fontSize = 12.sp)
                                }
                            }
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(horizontal = 16.dp)) {

                            }
                            Spacer(modifier = Modifier.padding(4.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                            ) {
                                Text(text = "Teman-teman, lihat re-kreasi van gog...",  fontSize = 12.sp)
                            }
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(64.dp)) }
        }
    }
}