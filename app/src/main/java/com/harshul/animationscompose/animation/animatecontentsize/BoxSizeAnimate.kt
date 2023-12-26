package com.harshul.animationscompose.animation.animatecontentsize

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.harshul.animationscompose.R

@Preview(showBackground = true)
@Composable
fun BoxSizeModifierAnimation() {

    var photoSizeSmall by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFDFE9FC))
            .toggleable(
                value = photoSizeSmall,
                onValueChange = { newValue -> photoSizeSmall = newValue }),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.ic_robot),
            contentDescription = "Tourists photo",
            modifier = Modifier
                .fillMaxSize(if (photoSizeSmall) 0.4f else 0.9f)
                .animateContentSize(),
            contentScale = ContentScale.Inside
        )
    }
}