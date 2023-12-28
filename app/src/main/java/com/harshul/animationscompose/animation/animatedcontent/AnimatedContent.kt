package com.harshul.animationscompose.animation.animatedcontent

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshul.animationscompose.R

@Preview(showBackground = true)
@Composable
fun AnimatedContentOne() {
    /**
     * AnimatedContent by default uses fade in out animation
     */

    /**
     * Count to keep track of the horizontal sliding counter
     */
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            stringResource(id = R.string.animated_content_sample_1),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0XFFDFE9FC)),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            IconButton(
                onClick = { if (count > 0) count-- },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color(0XFFA5C1F7)
                )
            }

            //Add AnimatedContent here around Box
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    if (targetState > initialState) {
                        (slideInHorizontally { width -> -width } + fadeIn()).togetherWith(
                            slideOutHorizontally { width -> width } + fadeOut()) using
                                SizeTransform { initialSize, targetSize ->
                                    keyframes {
                                        durationMillis = 300
                                        IntSize(
                                            initialSize.width / 2,
                                            targetSize.height / 2
                                        ) at 150
                                    }
                                }
                    } else {
                        (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                            slideOutHorizontally { width -> -width } + fadeOut())
                    }
                },
                label = "",
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0XFF3977EE))
            ) { targetState ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "$targetState",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            IconButton(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painterResource(id = R.drawable.add),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color(0XFFA5C1F7)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedContentSecond() {
    /**
     * Flag to expand or shrink the text content
     */
    var expand by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            stringResource(id = R.string.animated_content_sample_2),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Divider()
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

            AnimatedContent(
                targetState = expand,
                label = "Expand Collapse",
                transitionSpec = {
                    slideIntoContainer(towards = SlideDirection.Up) + fadeIn() togetherWith (slideOutOfContainer(
                        SlideDirection.Down
                    ) + fadeOut())
                }
            ) { targetState ->
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                        .clickable {
                            expand = !expand
                        }
                ) {
                    if (!targetState) {
                        Box(modifier = Modifier.wrapContentSize()) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp),
                                text = buildAnnotatedString {
                                    append(stringResource(id = R.string.user_bio_short))
                                    append(" ")
                                    withStyle(
                                        SpanStyle(
                                            color = Color(0XFF3977EE),
                                            textDecoration = TextDecoration.Underline,
                                            fontWeight = FontWeight.Medium
                                        )
                                    ) {
                                        append("Read more...")
                                    }
                                }
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 4.dp),
                                text = stringResource(id = R.string.user_bio_long)
                            )
                        }
                    }
                }
            }
        }
    }

}