package com.harshul.animationscompose.animation.valueanimation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class MySize(val height: Float, val width: Float)

@Preview(showBackground = true)
@Composable
fun BoxValueAnimate() {

    var clicked by remember { mutableStateOf(false) }
    val roundness by animateDpAsState(
        targetValue = if (clicked) 48.dp else 0.dp,
        label = "corner animated value"
    )

    val size by animateValueAsState(targetValue = if (clicked) {
        MySize(320f, 320f)
    } else MySize(200f, 200f),
        typeConverter = TwoWayConverter<MySize, AnimationVector2D>(
            convertFromVector = { vector ->
                MySize(vector.v1, vector.v2)
            },
            convertToVector = { size ->
                AnimationVector2D(size.width, size.height)
            }
        ), label = "Size animated value"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = animateColorAsState(
            targetValue = if (clicked) Color(0XFF3977EE) else Color(0XFFDFE9FC),
            label = "Background color changing"
        ).value
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .size(width = size.width.dp, height = size.height.dp)
                .clip(RoundedCornerShape(roundness))
                .clickable { clicked = !clicked }
                .background(
                    animateColorAsState(
                        targetValue = if (clicked) Color(0XFFDFE9FC) else Color(0XFF3977EE),
                        label = "Box color changing"
                    ).value
                )
        )

    }

}