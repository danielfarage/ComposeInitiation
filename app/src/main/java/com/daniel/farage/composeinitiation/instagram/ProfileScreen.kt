package com.daniel.farage.composeinitiation.instagram

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.daniel.farage.composeinitiation.R
import com.daniel.farage.composeinitiation.instagram.model.StoryHighlight
import com.daniel.farage.composeinitiation.mediaquery.Dimensions
import com.daniel.farage.composeinitiation.mediaquery.greaterThan
import com.daniel.farage.composeinitiation.mediaquery.lessThan
import com.daniel.farage.composeinitiation.mediaquery.mediaQuery

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "daniel_farage", modifier = Modifier
                .padding(10.dp)
                .mediaQuery(
                    comparator = Dimensions.Width lessThan 400.dp,
                    modifier = Modifier.background(
                        Color.Red
                    )
                )
                .mediaQuery(
                    comparator = Dimensions.Width greaterThan  400.dp,
                    modifier = Modifier.background(
                        Color.Green
                    )
                )
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection()
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            highlights = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.profile),
                    "eu mesmo"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.pedras),
                    "paisagens"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.pedras),
                    "paisagens"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.pedras),
                    "paisagens"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.music_knob),
                    "m??sicas"
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            postList = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_home),
                    "Posts"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.ic_bubble),
                    "Reels"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.ic_play),
                    "IGTV"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.ic_headphone),
                    "Profile"
                )
            )
        ) {
            selectedTabIndex = it
        }
        AnimatedVisibility(
            visible = selectedTabIndex == 0,
            enter = slideInVertically() + expandHorizontally(expandFrom = Alignment.Start),
            exit = slideOutHorizontally() + shrinkHorizontally()
        ) {
            PostSection(
                modifier = Modifier.fillMaxWidth(),
                posts = listOf(
                    painterResource(id = R.drawable.profile),
                    painterResource(id = R.drawable.pedras),
                    painterResource(id = R.drawable.profile),
                    painterResource(id = R.drawable.pedras),
                    painterResource(id = R.drawable.profile),
                    painterResource(id = R.drawable.pedras),
                    painterResource(id = R.drawable.profile)
                )
            )
        }
    }
}