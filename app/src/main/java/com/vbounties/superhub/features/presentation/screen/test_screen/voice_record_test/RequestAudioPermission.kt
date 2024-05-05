package com.vbounties.superhub.features.presentation.screen.test_screen.voice_record_test

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestAudioPermission() {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission Accepted: Do something
            Log.d("ExampleScreen", "PERMISSION GRANTED")
        } else {
            // Permission Denied: Do something
            Log.d("ExampleScreen", "PERMISSION DENIED")
        }
    }

    val context = LocalContext.current

    DisposableEffect(Unit) {
        val permission = android.Manifest.permission.RECORD_AUDIO

        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            // Some works that require permission
            Log.d("ExampleScreen", "Code requires permission")
        } else {
            // Asking for permission
            launcher.launch(permission)
        }

        onDispose {
            // No need to dispose of anything in this case
        }
    }
}