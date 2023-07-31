package com.example.whattodo.core

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.whattodo.R

val poppins = FontFamily(
    listOf(
        Font(R.font.poppins_bold, weight = FontWeight.Bold),
        Font(R.font.poppins_extrabold, weight = FontWeight.ExtraBold),
        Font(R.font.poppins_light, weight = FontWeight.Light),
        Font(R.font.poppins_regular, weight = FontWeight.Normal),
        Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    )
)