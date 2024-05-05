package com.vbounties.trufriend.features.presentation.screen.test_screen.video_record_test

import android.annotation.SuppressLint
import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.video.ExperimentalVideo
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
import androidx.compose.material.icons.rounded.SwitchCamera
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vbounties.trufriend.features.presentation.screen.test_screen.photo_capture_test.CameraView
import com.vbounties.trufriend.features.presentation.screen.test_screen.photo_capture_test.RequestCameraPermission

@OptIn(ExperimentalVideo::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun VideoRecordTest(){
    val viewModel = hiltViewModel<VideoViewModel>()
    var isCameraPermissionGranted by remember { mutableStateOf(false) }
    RequestCameraPermission{ isCameraPermissionGranted = true }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.VIDEO_CAPTURE)
        }
    }

    Scaffold(
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray), contentAlignment = Alignment.Center) {
                if(isCameraPermissionGranted){
                    CameraView(controller, Modifier.fillMaxSize())
                }
            }
        },
        bottomBar = {
            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color.Black)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        controller.cameraSelector =
                            if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                CameraSelector.DEFAULT_FRONT_CAMERA
                            } else CameraSelector.DEFAULT_BACK_CAMERA
                    }) {
                        Icon(imageVector = Icons.Rounded.SwitchCamera, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                    }

                    IconButton(onClick = {

                    }
                    ) {
                        Icon(imageVector = Icons.Rounded.Camera, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.Red)
                    }

                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Rounded.VideoLibrary, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                    }
                }
            }
        },

        floatingActionButton = {

        }
    )
}