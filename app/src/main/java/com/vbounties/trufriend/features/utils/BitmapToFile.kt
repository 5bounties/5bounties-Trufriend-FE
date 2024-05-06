package com.vbounties.trufriend.features.utils

import android.content.Context
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

fun BitmapToFile(context: Context, fileName: String, bitmap: Bitmap): File {
    //create a file to write bitmap data
    val file = File(context.cacheDir, fileName)
    file.createNewFile()

    //Convert bitmap to byte array
    val bos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos)
    val bitMapData = bos.toByteArray()

    //write the bytes in file
    var fos: FileOutputStream? = null
    try {
        fos = FileOutputStream(file)
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }

    try {
        fos?.write(bitMapData)
        fos?.flush()
        fos?.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return file
}

fun bitmapToFile2(context: Context, bitmap: Bitmap): File? {
    // Create a file to save the bitmap
    val file = File(context.cacheDir, "avatar.jpg")
    try {
        // Compress the bitmap to JPEG format and write it to the file
        val stream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        stream.flush()
        stream.close()
        return file
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}
