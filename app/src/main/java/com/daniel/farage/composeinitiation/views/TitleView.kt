package com.daniel.farage.composeinitiation.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(fontFamily: FontFamily) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Color.Green,
                    fontSize = 50.sp
                )
            ) {
                append("J")
            }
            append("etpack ")
            withStyle(
                SpanStyle(
                    color = Color.Green,
                    fontSize = 50.sp
                )
            ) {
                append("C")
            }
            append("ompose")
        },
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}