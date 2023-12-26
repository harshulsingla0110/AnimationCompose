package com.harshul.animationscompose.animation.infinitetransitions

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CircleAxisRotation() {
    //For infinite transition we need a transition object
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Transition Circles")
    val pitch by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 90f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFDFE9FC))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .background(Color(0XFF3977EE)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "X",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationX = pitch
                        }
                ) {
                    drawCircle(
                        radius = 64.dp.toPx(),
                        color = Color(0XFF3977EE),
                        style = Stroke(width = 4.dp.toPx())
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .background(Color(0XFF3977EE)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Y",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationY = pitch
                        }
                ) {
                    drawCircle(
                        radius = 64.dp.toPx(),
                        color = Color(0XFF3977EE),
                        style = Stroke(width = 4.dp.toPx())
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .background(Color(0XFF3977EE)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Z",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationZ = pitch
                        }
                ) {
                    drawCircle(
                        radius = 64.dp.toPx(),
                        color = Color(0XFF3977EE),
                        style = Stroke(width = 4.dp.toPx())
                    )
                }
            }
        }
    }


}