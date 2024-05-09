package com.vbounties.trufriend.features.presentation.design_system

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vbounties.trufriend.R

val TrufriendSatoshi = FontFamily(
    Font(R.font.satoshilight, FontWeight.Thin),
    Font(R.font.satoshibold, FontWeight.SemiBold),
    Font(R.font.satoshiregular, FontWeight.Normal),
    Font(R.font.satoshimedium, FontWeight.Medium),
    Font(R.font.satoshilight, FontWeight.Light),
    Font(R.font.satoshilight, FontWeight.ExtraLight),
    Font(R.font.satoshiblack, FontWeight.ExtraBold),
    Font(R.font.satoshibold, FontWeight.Bold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = TrufriendSatoshi, //FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)