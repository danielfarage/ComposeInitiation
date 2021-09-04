package com.daniel.farage.composeinitiation.views

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daniel.farage.composeinitiation.R
import com.daniel.farage.composeinitiation.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SpashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            0.6f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)
                }
            )
        )
        delay(3000)
        navController.navigate(Screen.MainScreen.route)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Dan",
            modifier = Modifier.scale(scale.value)

        )
    }
}