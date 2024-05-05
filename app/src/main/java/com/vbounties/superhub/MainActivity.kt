package com.vbounties.superhub

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.video.ExperimentalVideo
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.vbounties.superhub.features.presentation.design_system.SuperhubTheme
import com.vbounties.superhub.features.presentation.screen.test_screen.photo_capture_test.CameraView
import com.vbounties.superhub.features.presentation.screen.test_screen.photo_capture_test.PhotoCaptureTest
import com.vbounties.superhub.features.presentation.screen.test_screen.photo_capture_test.RequestCameraPermission
import com.vbounties.superhub.features.presentation.screen.test_screen.voice_record_test.VoiceRecordTest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalVideo::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperhubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { //innerPadding ->
                    //VoiceRecordTest()
                    PhotoCaptureTest()
                }
            }
        }
    }
}
