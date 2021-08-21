package com.daniel.farage.composeinitiation.views

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Animations() {
    var sizeBox by remember { mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeBox,
        /*keyframes {
            durationMillis = 5000
            sizeBox at 0 with LinearEasing
            sizeBox * 1.5f at 1000 with FastOutLinearInEasing
            sizeBox * 2f at 5000
        }*/
        //spring(stiffness = Spring.StiffnessHigh)
        tween(durationMillis = 1000)

    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 5000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { sizeBox += 50.dp }) {
            Text("Alterar tamanho")
        }
    }
}