package com.daniel.farage.composeinitiation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.daniel.farage.composeinitiation.dropdown.DropDown
import com.daniel.farage.composeinitiation.timer.TimerCountdown
import com.daniel.farage.composeinitiation.views.ImageCard
import com.daniel.farage.composeinitiation.views.TitleView

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                color = Color(0xFF101010),
                modifier = Modifier.fillMaxSize()
            ) {
                DropDown(text = "Teste", modifier = Modifier.padding(15.dp)) {
                    TimerCountdown()
                }
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