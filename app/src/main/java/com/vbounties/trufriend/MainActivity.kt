package com.vbounties.trufriend

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.camera.view.video.ExperimentalVideo
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.vbounties.trufriend.features.presentation.design_system.SuperhubTheme
import com.vbounties.trufriend.features.presentation.screen.test_screen.TestScreen
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
                    TestScreen()
                }
            }
        }
    }
}
