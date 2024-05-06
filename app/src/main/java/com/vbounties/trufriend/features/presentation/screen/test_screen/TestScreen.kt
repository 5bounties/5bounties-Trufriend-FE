package com.vbounties.trufriend.features.presentation.screen.test_screen

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.KeyboardVoice
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.presentation.screen.login_screen.LoginViewModel
import com.vbounties.trufriend.features.presentation.screen.test_screen.photo_capture_test.PhotoCaptureTest
import com.vbounties.trufriend.features.presentation.screen.test_screen.video_record_test.VideoRecordTest
import com.vbounties.trufriend.features.presentation.screen.test_screen.voice_record_test.VoiceRecordTest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreen(){
    val navController = rememberNavController()
    val selected = remember { mutableStateOf(0) }
    val viewModel = hiltViewModel<LoginViewModel>()



    Scaffold(
        topBar = {
                Column(){
                    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color.Black)) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = {
                                navController.navigate("capture_photo")
                                selected.value = 0
                            }
                            ) {
                                Icon(imageVector = Icons.Rounded.Image, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = if(selected.value == 0) Color.Yellow else Color.White)
                            }

                            IconButton(onClick = {
                                navController.navigate("voice_record")
                                selected.value = 1
                            }
                            ) {
                                Icon(imageVector = Icons.Rounded.KeyboardVoice, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = if(selected.value == 1) Color.Yellow else Color.White)
                            }

                            IconButton(onClick = {
                                navController.navigate("video_record")
                                selected.value = 2
                            }
                            ) {
                                Icon(imageVector = Icons.Rounded.Videocam, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = if(selected.value == 2) Color.Yellow else Color.White)
                            }
                        }
                    }
                    Text(text = viewModel.loginstate.collectAsState().value.toString())
                }

        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)){
                NavHost(navController = navController, startDestination = "capture_photo"){
                    composable("capture_photo"){
                        PhotoCaptureTest()
                    }

                    composable("voice_record"){
                        VoiceRecordTest()
                    }

                    composable("video_record"){
                        VideoRecordTest()
                    }
                }
            }
        }
    )
}