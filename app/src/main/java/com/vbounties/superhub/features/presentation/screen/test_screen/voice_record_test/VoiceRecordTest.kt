package com.vbounties.superhub.features.presentation.screen.test_screen.voice_record_test

import android.media.MediaRecorder
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import java.io.File

@Composable
@Preview
fun VoiceRecordTest(){
    var viewModel = hiltViewModel<VoiceViewModel>()
    var recorder: MediaRecorder? = MediaRecorder()
    var isRecording by remember { mutableStateOf(false) }
    var audioFile: File? by remember { mutableStateOf(null) }

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
                    if (recorder != null) {
                        viewModel.startRecording(recorder)
                    }
                } else {
                    if (recorder != null) {
                        viewModel.stopRecording(recorder){
                            audioFile = it
                        }
                    }
                }
            }
        ) {
            Text(text = if (isRecording) "Stop Recording" else "Start Recording")
        }

        if (audioFile != null) {
            Button(
                onClick = {
                    viewModel.playRecording(audioFile!!)
                }
            ) {
                Text(text = "Play Recording")
            }
        }
    }
}
