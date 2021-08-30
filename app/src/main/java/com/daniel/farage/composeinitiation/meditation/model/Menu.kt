package com.daniel.farage.composeinitiation.meditation.model

import androidx.annotation.DrawableRes
import com.daniel.farage.composeinitiation.R

data class Menu(
    val title: String,
    @DrawableRes
    val icon: Int
)

fun menuList() = listOf(
    Menu("Home", R.drawable.ic_home),
    Menu("Meditate", R.drawable.ic_bubble),
    Menu("Sleep", R.drawable.ic_moon),
    Menu("Music", R.drawable.ic_music),
    Menu("Profile", R.drawable.ic_profile),
)
