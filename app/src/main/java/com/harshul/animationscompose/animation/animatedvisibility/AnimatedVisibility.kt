package com.harshul.animationscompose.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshul.animationscompose.R


@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun AnimatedVisibility() {

    //allows to run animation automatically.. pass this as a param in AnimatedVisibility(visibleState)
    //for this checkbox state not required
    val show = remember { MutableTransitionState(false).apply { targetState = true } }
    val (checked, onCheckedChange) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .shadow(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = onCheckedChange)
            Text(text = "Show Content")
        }

        AnimatedVisibility(
            visible = checked,
            modifier = Modifier.padding(horizontal = 16.dp),
            enter = fadeIn() + expandIn(),
            exit = shrinkOut(shrinkTowards = Alignment.TopStart, animationSpec = tween(1000)),
            label = "animated visibility"
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0XFFDFE9FC))
                    .padding(bottom = 16.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.user),
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(160.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    text = "CodeCraft Enthusiast",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )

                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.wrapContentSize()) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .animateEnterExit(exit = slideOutHorizontally()),
                            text = stringResource(id = R.string.user_bio_short)
                        )
                    }
                }
            }
        }
    }
}