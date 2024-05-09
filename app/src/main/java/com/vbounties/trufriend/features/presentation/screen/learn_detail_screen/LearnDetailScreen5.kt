package com.vbounties.trufriend.features.presentation.screen.learn_detail_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.presentation.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun LearnDetailScreen5(
    bottomController: NavController = rememberNavController()
){
    val lifecycle = remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner){
        val observer =
            LifecycleEventObserver { _, event -> lifecycle.value = event }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
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
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "back", modifier = Modifier.clickable {
                        bottomController.navigate(BottomNavigation.Learn.route)
                    }, tint = Color.White)
                    Text(text = "Kembali", modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                }
            }
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF7F0))){
                LazyColumn(modifier = Modifier
                    .fillMaxSize()) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp),
                            shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                            colors = CardDefaults.cardColors(Color.Black)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(), contentAlignment = Alignment.BottomCenter
                            ) {
                                AndroidView(factory = {context ->
                                    PlayerView(context)
                                }, modifier = Modifier
                                    .fillMaxSize(),
                                    update = {
                                        when(lifecycle.value){
                                            Lifecycle.Event.ON_PAUSE -> {

                                            }

                                            Lifecycle.Event.ON_RESUME -> {

                                            }
                                            else -> Unit
                                        }
                                    }
                                )
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(12.dp)) }
                    item {
                        Text(
                            text = "Teach Children with Autism",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    item { Spacer(modifier = Modifier.padding(4.dp)) }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth().padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Card(modifier = Modifier.size(30.dp),
                                shape = CircleShape,
                                colors = CardDefaults.cardColors(Color(0xFFFEB664)),
                                border = BorderStroke(2.dp, color = Color(0xFFFEB664))
                            ) {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Icon(imageVector = Icons.Rounded.PersonOutline, contentDescription = "profile", tint = Color.White)
                                }
                            }
                            Spacer(modifier = Modifier.padding(6.dp))
                            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                                Text(text = "Dr. Mary Barbera", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(4.dp)) }
                    item {
                        Row(modifier = Modifier
                            .fillMaxWidth().height(40.dp).padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                            Text(
                                text = "Deskripsi",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                            )
                            Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){
                                Icon(imageVector = Icons.Rounded.KeyboardArrowDown, contentDescription = "profile", tint = Color.Black, modifier = Modifier.fillMaxSize())
                            }
                        }

                    }
                }
            }
        }
    )
}