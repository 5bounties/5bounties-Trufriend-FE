package com.vbounties.trufriend.features.domain.model

import com.vbounties.trufriend.R

data class EmotionModel(
    val emotion: String,
    val resource: Int
)

object EmotionType{
    val DEFAULT = EmotionModel("default", R.drawable.mood0)
    val DATAR   = EmotionModel("fine", R.drawable.mood1)
    val SEDIH   = EmotionModel("sad", R.drawable.mood2)
    val BAHAGIA = EmotionModel("awesome", R.drawable.mood3)
    val CEMAS   = EmotionModel("worried", R.drawable.mood4)
    val MARAH   = EmotionModel("angry", R.drawable.mood5)
}