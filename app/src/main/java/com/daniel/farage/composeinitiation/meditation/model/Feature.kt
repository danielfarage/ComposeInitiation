package com.daniel.farage.composeinitiation.meditation.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.daniel.farage.composeinitiation.R
import com.daniel.farage.composeinitiation.ui.theme.*

data class Feature(
    val title: String,
    @DrawableRes
    val icon: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkerColor: Color
)

fun featureList() = listOf(
    Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        title = "Calming sounds",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3
    )
)

