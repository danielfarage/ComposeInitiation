package com.daniel.farage.composeinitiation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.farage.composeinitiation.meditation.HomeScreen
import com.daniel.farage.composeinitiation.ui.theme.ComposeInitiationTheme
import com.daniel.farage.composeinitiation.views.AudioSwitcher
import com.daniel.farage.composeinitiation.views.ImageCard
import com.daniel.farage.composeinitiation.views.TitleView
import com.daniel.farage.composeinitiation.views.VolumeBar
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeInitiationTheme {
                HomeScreen()
            }
        }
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5, showSystemUi = false)
@Composable
fun DefaultPreview() {
    TitleView(
        FontFamily(
            Font(R.font.georama_light, weight = FontWeight.Light),
            Font(R.font.georama_bold, weight = FontWeight.Bold)
        )
    )
    ImageCard(
        painter = painterResource(id = R.drawable.pedras),
        contentDescription = "Pedras empilhadas",
        title = "Pilha de pedras"
    )
}