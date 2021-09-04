package com.daniel.farage.composeinitiation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.daniel.farage.composeinitiation.bottomnavigation.BottomNavItem
import com.daniel.farage.composeinitiation.bottomnavigation.BottomNavigationBar
import com.daniel.farage.composeinitiation.bottomnavigation.Navigation
import com.daniel.farage.composeinitiation.ui.theme.ComposeInitiationTheme
import com.daniel.farage.composeinitiation.views.ImageCard
import com.daniel.farage.composeinitiation.views.TitleView

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeInitiationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    "Home",
                                    "home",
                                    Icons.Default.Home
                                ),
                                BottomNavItem(
                                    "Chat",
                                    "chat",
                                    Icons.Default.Notifications,
                                    465
                                ),
                                BottomNavItem(
                                    "Settings",
                                    "settings",
                                    Icons.Default.Settings
                                )
                            ),
                            navController = navController,
                            onItemClick = { navController.navigate(it.route) }
                        )
                    }
                ) {
                    Navigation(navController)
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