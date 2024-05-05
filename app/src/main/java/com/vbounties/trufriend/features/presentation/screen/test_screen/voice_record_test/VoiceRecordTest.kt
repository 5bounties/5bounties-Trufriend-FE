package com.vbounties.trufriend.features.presentation.screen.test_screen.voice_record_test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import java.io.File

@Composable
@Preview
fun VoiceRecordTest(){
    var viewModel = hiltViewModel<VoiceViewModel>()
    var isRecording by remember { mutableStateOf(false) }
    var isPlaying by remember { mutableStateOf(false) }
    var audioFile: File? by remember { mutableStateOf(null) }
    var countDuration by remember { mutableStateOf(0) }

    RequestAudioPermission()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                isRecording = !isRecording
                if (isRecording) {
                    countDuration = 0
                    viewModel.startRecording()
                } else {
                    viewModel.stopRecording(){
                        audioFile = it
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = if (isRecording) "Stop Recording" else "Start Recording")
        }

        if (isRecording) {
            LaunchedEffect(key1 = Unit) {
                while(true){
                    delay(1000)
                    countDuration++
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Duration: $countDuration seconds", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (audioFile != null) {
            Button(
                onClick = {
                    viewModel.playRecording(audioFile!!)
                    isPlaying = true
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Play Recording")
            }
        }

        if (isPlaying) {
            val temp = remember {
                mutableStateOf(countDuration)
            }
            LaunchedEffect(key1 = Unit) {
                while (true){
                    delay(1000)
                    countDuration--
                    if(countDuration == 0){
                        isPlaying = false
                        countDuration = temp.value
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(color = Color.Black, progress = countDuration.toFloat() / temp.value)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Duration: $countDuration seconds", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
