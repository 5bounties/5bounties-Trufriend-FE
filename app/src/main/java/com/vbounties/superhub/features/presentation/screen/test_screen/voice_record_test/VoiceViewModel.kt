package com.vbounties.superhub.features.presentation.screen.test_screen.voice_record_test

import android.media.MediaPlayer
import android.media.MediaRecorder
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class VoiceViewModel @Inject constructor(): ViewModel() {
    private val audioFile = File.createTempFile("recording", ".mp3")

    fun startRecording(recorder: MediaRecorder) {
        // Initialize MediaRecorder
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        recorder.setOutputFile(this.audioFile.absolutePath)

        // Start recording
        recorder.prepare()
        recorder.start()
        Log.d("fun startRecording(recorder: MediaRecorder)", "Recording started")
    }

    fun stopRecording(recorder: MediaRecorder, onFinished: (File) -> Unit) {
        // Stop recording and release resources
        recorder.stop()
        recorder.release()
        onFinished(this.audioFile)
        Log.d("fun stopRecording(recorder: MediaRecorder)", "Recording stopped")
    }

    fun playRecording(audioFile: File) {
        // Initialize MediaPlayer
        val player = MediaPlayer()
        player.setDataSource(audioFile.absolutePath)

        // Start playback
        player.prepare()
        player.start()
        if(player.isPlaying){
            Log.d("fun playRecording(audioFile: File)", "Playing recording")
        } else {
            Log.d("fun playRecording(audioFile: File)", "Failed to play recording")
        }
    }
}