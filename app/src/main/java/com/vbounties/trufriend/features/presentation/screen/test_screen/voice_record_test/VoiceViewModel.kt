package com.vbounties.trufriend.features.presentation.screen.test_screen.voice_record_test

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
    private var recorder = MediaRecorder()
    fun setRecorder(recorder: MediaRecorder){
        this.recorder = recorder
    }

    fun startRecording() {
        audioFile.delete()
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

    fun stopRecording(onFinished: (File) -> Unit) {
        // Stop recording and release resources
        recorder.stop()
        recorder.release()
        onFinished(this.audioFile)
        Log.d("fun stopRecording(recorder: MediaRecorder)", "Recording stopped")
        recorder = MediaRecorder()
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