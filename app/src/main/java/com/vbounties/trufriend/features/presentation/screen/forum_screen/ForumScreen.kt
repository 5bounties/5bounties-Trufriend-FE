package com.vbounties.trufriend.features.presentation.screen.forum_screen

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddComment
import androidx.compose.material.icons.rounded.Comment
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState

@Composable
@Preview
fun ForumScreen(
    parentController: NavController = rememberNavController(),
    bottomController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<ForumViewModel>()
    val forum = remember { mutableStateOf(ForumState()) }
    viewModel.getAllPost {
        forum.value = it
    }
    val user = remember { mutableStateOf(UserState()) }
    viewModel.getUser {
        user.value = it
    }

    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFDF7F0))){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)){
            item { Spacer(modifier = Modifier.padding(24.dp)) }
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Card(modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            parentController.navigate(ParentNavigation.Profile.route)
                        },
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(Color(0xFFFFB764)),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ){
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(id = R.drawable.user), contentDescription = "user", tint = Color.White, modifier = Modifier.fillMaxSize(0.5f))
                            AsyncImage(model = "https://uitrssskfwjwscymocmu.supabase.co/storage/v1/object/public/avatar/" + user.value.data.avatarUrl.substringAfterLast("/"), contentDescription = "avatar", imageLoader = ImageLoader(context), modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                    }
                    Box(modifier = Modifier.size(72.dp), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.logoxl), contentDescription = "logo", modifier = Modifier.fillMaxSize())
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Card(modifier = Modifier
                            .width(50.dp)
                            .height(36.dp),
                            colors = CardDefaults.cardColors(Color.White),
                            border = BorderStroke(1.dp, Color.Gray)
                        ){
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .clickable {

                                }, contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.Email, contentDescription = "user", tint = Color.Gray, modifier = Modifier.fillMaxSize(0.6f))
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.padding(8.dp))
                HorizontalDivider()
            }

            items(forum.value.data.data){
                if(it.isVisible){
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier.size(30.dp),
                                shape = CircleShape,
                                colors = CardDefaults.cardColors(Color(0xFFFEB664)),
                                border = BorderStroke(2.dp, color = Color(0xFFFEB664))
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.PersonOutline,
                                        contentDescription = "profile",
                                        tint = Color.White
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.padding(6.dp))
                            Text(
                                text = "Username",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(text = "@username", fontSize = 14.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(text = "|  01 Jan 2024", fontSize = 14.sp, color = Color.Gray)
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        if (!it.imageUrl.substringAfterLast("/").equals("undefined")) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp),
                                shape = RectangleShape,
                                border = BorderStroke(1.dp, Color.Gray)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    AsyncImage(
                                        model = "https://uitrssskfwjwscymocmu.supabase.co/storage/v1/object/public/avatar/" + it.imageUrl.substringAfterLast(
                                            "/"
                                        ),
                                        contentDescription = "avatar",
                                        imageLoader = ImageLoader(context),
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(50.dp)
                                            .padding(8.dp)
                                    ) {
                                        Card(
                                            modifier = Modifier
                                                .width(80.dp)
                                                .height(40.dp),
                                            elevation = CardDefaults.cardElevation(2.dp),
                                            colors = CardDefaults.cardColors(Color(0xFFFDF7F0))
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(start = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Rounded.ThumbUp,
                                                    contentDescription = "comment"
                                                )
                                                Spacer(modifier = Modifier.padding(8.dp))
                                                Text(text = it.likes.size.toString())
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Card(
                                            modifier = Modifier
                                                .width(40.dp)
                                                .height(40.dp),
                                            elevation = CardDefaults.cardElevation(2.dp),
                                            colors = CardDefaults.cardColors(Color(0xFFFDF7F0))
                                        ) {
                                            Box(
                                                modifier = Modifier.fillMaxSize(),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Rounded.Comment,
                                                    contentDescription = "comment"
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                border = BorderStroke(1.dp, Color.Gray),
                                colors = CardDefaults.cardColors(Color.White)
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(text = it.content)
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        } else {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                border = BorderStroke(1.dp, Color.Gray),
                                colors = CardDefaults.cardColors(Color.White)
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(text = it.content)
                                }

                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(36.dp),
                                    elevation = CardDefaults.cardElevation(2.dp),
                                    colors = CardDefaults.cardColors(Color(0xFFFEB664))
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.ThumbUp,
                                            contentDescription = "comment",
                                            tint = Color.White
                                        )
                                        Spacer(modifier = Modifier.padding(8.dp))
                                        Text(text = it.likes.size.toString(), color = Color.White)
                                    }
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Card(
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(36.dp),
                                    elevation = CardDefaults.cardElevation(2.dp),
                                    colors = CardDefaults.cardColors(Color(0xFFFEB664))
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Comment,
                                            contentDescription = "comment",
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}