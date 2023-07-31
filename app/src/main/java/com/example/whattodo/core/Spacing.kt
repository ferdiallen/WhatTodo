package com.example.whattodo.core

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val smallSpacing: Dp = 4.dp,
    val mediumSpacing: Dp = 8.dp,
    val largeSpacing: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
    val largestSpacing: Dp = 64.dp
)

val LocalSpacing = compositionLocalOf {
    Spacing()
}

val MaterialTheme.spacing: Spacing
    @ReadOnlyComposable
    @Composable
    get() = LocalSpacing.current