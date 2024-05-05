package com.vbounties.superhub.features.presentation.screen.test_screen.photo_capture_test

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun RequestCameraPermission(
    onPermissionGranted: () -> Unit
){
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission Accepted: Do something
            Log.d("ExampleScreen", "PERMISSION GRANTED")
            onPermissionGranted()
        } else {
            // Permission Denied: Do something
            Log.d("ExampleScreen", "PERMISSION DENIED")
        }
    }

    val context = LocalContext.current

    DisposableEffect(Unit) {
        val permission = Manifest.permission.CAMERA

        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            // Some works that require permission
            Log.d("ExampleScreen", "Code requires permission")
            onPermissionGranted()
        } else {
            // Asking for permission
            launcher.launch(permission)
        }

        onDispose {
            // No need to dispose of anything in this case
        }
    }
}