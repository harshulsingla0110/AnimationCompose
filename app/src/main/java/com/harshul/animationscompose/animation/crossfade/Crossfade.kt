package com.harshul.animationscompose.animation.crossfade


import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshul.animationscompose.R

enum class Travel {
    Globe,
    Rocket,
    Helicopter,
    Plan,
    All
}

@Composable
fun `Cross-fadeDemo`() {
    /**
     * Enum variable to select a picture to cross-fade to
     */
    var pick by remember { mutableStateOf(Travel.Globe) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Text(
            stringResource(id = R.string.crossfade_animation_sample),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Divider()

        val targetState = pick
        Crossfade(
            targetState = targetState,
            label = "",
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
        ) { picture ->
            Box(
                Modifier
                    .fillMaxSize()
                    .clickable {
                        val items = Travel.entries.toTypedArray()
                        val nextItem =
                            if (picture.ordinal < items.size - 1) items[picture.ordinal + 1] else items[0]
                        pick = nextItem
                    }) {
                Text(
                    targetState.name,
                    Modifier
                        .align(Alignment.TopCenter)
                        .padding(8.dp),
                    fontSize = 30.sp, fontWeight = FontWeight.Bold
                )
                when (targetState) {
                    Travel.Globe -> {
                        Image(painterResource(id = R.drawable.ic_globe), null)
                    }

                    Travel.Rocket -> {
                        Image(painterResource(id = R.drawable.ic_rocket), null)

                    }

                    Travel.Helicopter -> {
                        Image(painterResource(id = R.drawable.ic_helicopter), null)
                    }

                    Travel.Plan -> {
                        Image(painterResource(id = R.drawable.ic_plane), null)
                    }

                    Travel.All -> {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(top = 48.dp)) {
                            val pics = listOf(
                                R.drawable.ic_globe, R.drawable.ic_rocket,
                                R.drawable.ic_helicopter, R.drawable.ic_plane
                            )
                            for (pic in pics)
                                Image(
                                    painterResource(id = pic),
                                    null,
                                    Modifier
                                        .weight(1f)
                                        .align(Alignment.Bottom)
                                        .graphicsLayer {
                                            if (pic == R.drawable.ic_globe) rotationY = 180f
                                        }
                                )
                        }
                    }
                }
            }
        }
    }
}