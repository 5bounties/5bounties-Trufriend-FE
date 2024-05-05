package com.vbounties.superhub.features.presentation.screen.test_screen

import android.annotation.SuppressLint
import androidx.camera.core.CameraSelector
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.KeyboardVoice
import androidx.compose.material.icons.rounded.SwitchCamera
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vbounties.superhub.features.presentation.screen.test_screen.photo_capture_test.PhotoCaptureTest
import com.vbounties.superhub.features.presentation.screen.test_screen.video_record_test.VideoRecordTest
import com.vbounties.superhub.features.presentation.screen.test_screen.voice_record_test.VoiceRecordTest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
                 Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color.Black)) {
                     Row(modifier = Modifier
                         .fillMaxWidth()
                         .padding(horizontal = 32.dp, vertical = 12.dp),
                         horizontalArrangement = Arrangement.SpaceBetween
                     ) {
                         IconButton(onClick = { navController.navigate("capture_photo") }
                         ) {
                             Icon(imageVector = Icons.Rounded.Image, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                         }

                         IconButton(onClick = { navController.navigate("voice_record") }
                         ) {
                             Icon(imageVector = Icons.Rounded.KeyboardVoice, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                         }

                         IconButton(onClick = { navController.navigate("video_record") }
                         ) {
                             Icon(imageVector = Icons.Rounded.Videocam, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                         }
                     }
                 }
        },
        content = {
            Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)){
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