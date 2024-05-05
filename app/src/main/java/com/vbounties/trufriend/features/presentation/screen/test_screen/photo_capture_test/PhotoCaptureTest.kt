package com.vbounties.trufriend.features.presentation.screen.test_screen.photo_capture_test

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.SwitchCamera
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun PhotoCaptureTest(){
    val viewModel = hiltViewModel<PhotoViewModel>()
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    val showCapturedImage = remember { mutableStateOf(false) }

    var isCameraPermissionGranted by remember { mutableStateOf(false) }
    RequestCameraPermission{ isCameraPermissionGranted = true }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }

    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray), contentAlignment = Alignment.Center) {
                if(showCapturedImage.value){
                    Image(
                        bitmap = bitmap.value!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(0.7f).padding(bottom = 32.dp).clip(RoundedCornerShape(16.dp)),
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop)
                } else {
                    if(isCameraPermissionGranted){
                        CameraView(controller, Modifier.fillMaxSize())
                    }
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

                    IconButton(onClick = { viewModel.takePhoto(context, controller){
                        bitmap.value = it
                    } }) {
                        Icon(imageVector = Icons.Rounded.Camera, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                    }

                    IconButton(onClick = {
                        showCapturedImage.value = !showCapturedImage.value
                    }) {
                        Icon(imageVector = Icons.Rounded.Image, contentDescription = "Camera", modifier = Modifier.size(80.dp), tint = Color.White)
                    }
                }
            }
        },

        floatingActionButton = {
            if(!showCapturedImage.value){
                bitmap.value?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp).border(4.dp, Color.Black),
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop
                    )
                }
            }
        }
    )

}