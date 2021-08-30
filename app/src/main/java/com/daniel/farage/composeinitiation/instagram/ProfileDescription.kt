package com.daniel.farage.composeinitiation.instagram

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpace = 0.5.sp
    val lineHeight = 20.sp
    
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            letterSpacing = letterSpace,
            color = Color(0xFF2196F3),
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                    append("Seguido por ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" e ")
                        pushStyle(boldStyle)
                        append("$otherCount outros")
                    }
                },
                lineHeight = lineHeight,
                letterSpacing = letterSpace
            )
        }
    }
}