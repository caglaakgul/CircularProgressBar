package com.caglaakgul.circularprogressbarlibrary

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressBarView(
    progress: Float,
    size: Dp,
    strokeWidth: Dp,
    color: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Canvas(
            modifier = Modifier
                .size(size)
                .padding(top = 32.dp, start = strokeWidth / 2)
                .aspectRatio(1f)
        ) {
            val canvasWidth = size.toPx()
            val canvasHeight = size.toPx()

            val center = Offset(canvasWidth / 2, canvasHeight / 2)
            val radius = (canvasWidth - strokeWidth.toPx()) / 2

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
                size = Size(radius * 2, radius * 2)
            )
        }
    }
}

@Composable
fun CircularProgressBarWithTime(
    totalTimeInSeconds: Int,
    size: Dp,
    strokeWidth: Dp,
    color: Color
) {
    var elapsedTimeInSeconds by remember { mutableIntStateOf(0) }
    val progress = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = totalTimeInSeconds * 1000),
                repeatMode = RepeatMode.Restart
            )
        ) {
            elapsedTimeInSeconds = (progress.value * totalTimeInSeconds).toInt()
        }
    }

    CircularProgressBarView(
        progress = progress.value,
        size = size,
        strokeWidth = strokeWidth,
        color = color
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CircularProgressBarPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressBarWithTime(
                totalTimeInSeconds = 100,
                size = 200.dp,
                strokeWidth = 8.dp,
                color = Color.Blue
            )
        }
    }
}