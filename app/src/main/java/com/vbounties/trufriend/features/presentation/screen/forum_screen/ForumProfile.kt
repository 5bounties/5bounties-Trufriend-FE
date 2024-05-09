package com.vbounties.trufriend.features.presentation.screen.forum_screen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.util.TableInfo
import coil.ImageLoader
import coil.compose.AsyncImage
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun ForumProfile(
    bottomController: NavController = rememberNavController()
){
    val context = LocalContext.current
    val user = remember { mutableStateOf(UserState()) }
    val viewModel = hiltViewModel<ForumViewModel>()
    viewModel.getUser {
        user.value = it
    }

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
                    Card(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable {
                            bottomController.navigate(BottomNavigation.Forum.route)
                        }
                        , colors = CardDefaults.cardColors(Color(0xFFC36528))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "add", modifier = Modifier.fillMaxSize(0.6f), tint = Color.White)
                        }
                    }
                }
            }
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF7F0))){
                LazyColumn(modifier = Modifier
                    .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                    item {
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                            shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF0DAC3))
                        ) {
                            Box(modifier = Modifier
                                .fillMaxSize(), contentAlignment = Alignment.BottomCenter){
                                AsyncImage(model = "https://uitrssskfwjwscymocmu.supabase.co/storage/v1/object/public/avatar/" + user.value.data.avatarUrl.substringAfterLast("/"), contentDescription = "avatar", imageLoader = ImageLoader(context), modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                    Column {
                                        Text(text = user.value.data.name, fontSize = 42.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        Text(text = "@${user.value.data.username}", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
                                    }
                                    Card(modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .clickable {

                                        }
                                        , colors = CardDefaults.cardColors(Color(0xFFFEB664))
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                            Icon(imageVector = Icons.Rounded.Create, contentDescription = "add", modifier = Modifier.fillMaxSize(0.6f), tint = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(12.dp)) }
                    item {
                        Card(modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(80.dp),
                            shape = RoundedCornerShape(50.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFEB664)),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "Post", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                    Spacer(modifier = Modifier.padding(2.dp))
                                    Text(text = "0", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "Bookmark", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                    Spacer(modifier = Modifier.padding(2.dp))
                                    Text(text = "0", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "Followers", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                    Spacer(modifier = Modifier.padding(2.dp))
                                    Text(text = "0", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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