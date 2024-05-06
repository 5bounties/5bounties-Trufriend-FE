package com.vbounties.trufriend.features.utils

import android.content.Context
import android.graphics.Bitmap
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody

fun buildImageBodyPart(context: Context, fileName: String, bitmap: Bitmap):  MultipartBody.Part {
    val leftImageFile = BitmapToFile(context,fileName, bitmap)
    val reqFile =  leftImageFile.asRequestBody()
    return MultipartBody.Part.createFormData("file", "file", reqFile)
}