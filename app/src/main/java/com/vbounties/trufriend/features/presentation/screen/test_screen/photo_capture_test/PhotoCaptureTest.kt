package com.vbounties.trufriend.features.presentation.screen.test_screen.photo_capture_test

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.domain.model.RegisterModel
import com.vbounties.trufriend.features.presentation.screen.login_screen.LoginViewModel
import com.vbounties.trufriend.features.utils.uriToBitmap
import java.io.File


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun PhotoCaptureTest(){
    val viewModel = hiltViewModel<PhotoViewModel>()
    val viewModel2 = hiltViewModel<LoginViewModel>()
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

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImageUri.value = uri
            bitmap.value = selectedImageUri.value?.let { uriToBitmap(context, it) }
        }
    )

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
//                        bitmap.value?.let {
//                            RegisterModel(
//                                name     = "test login",
//                                username = "testlogin",
//                                password = "testpassword",
//                                email    = "testlogin@test.com",
//                                avatar   = it
//                            )
//                        }?.let { viewModel2.register(context = context, request = it) }
//                        viewModel2.login(LoginModel(email = "nugrahabilly@gmail.com", password = "nugrahabilly"))

//                        bitmap.value?.let {
//                            RegisterModel(
//                                name     = "test login",
//                                username = "testlogin",
//                                password = "testpassword",
//                                email    = "testlogin@test.com",
//                                avatar   = it
//                            )
//                        }?.let { viewModel2.register(context, it) }
                        viewModel2.login(LoginModel(email = "testlogin@test.com", password = "testpassword"))
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
                        modifier = Modifier.size(80.dp).border(4.dp, Color.Black).clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop
                    )
                }
            }
        }
    )

}