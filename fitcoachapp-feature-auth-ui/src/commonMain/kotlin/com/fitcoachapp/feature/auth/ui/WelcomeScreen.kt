package com.fitcoachapp.feature.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fitcoachapp.feature.auth.ui.style.FitCoachAppPalette
import com.seiko.imageloader.ImageRequestState
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun Welcome() {
    val viewModel = UserViewModel()

    val user = viewModel.userStateFlow.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            url = "https://firebasestorage.googleapis.com/v0/b/fitcoachapp-39ba0.appspot.com/o/woman.svg?alt=media&token=de195dbd-7658-4efd-b5eb-0b3a26f7cfac",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(FitCoachAppPalette.uiGradientA, FitCoachAppPalette.uiGradientB),
                        startY = 0f,
                        endY = 300f
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 256 .dp)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Text(
                text = "Welcome, ${user.name}!",
                style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Train and live the new experience of\n" +
                        "personalized exercising at home",
                style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .run {
                        clickable {
                            // TODO: Navigate to sign in screen
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text("Continue with Google", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.Black)
                    .run {
                        clickable {
                            // TODO: Navigate to sign in screen
                            viewModel.getUser("1234")
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text("Continue with Apple", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.Transparent)
                    .border(1.dp, Color.White, CircleShape)
                    .run {
                        clickable {
                            // TODO: Navigate to sign in screen
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text("Login", color = Color.White)
            }

            Text(
                text = "Don't have an account? Sign up",
                style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Divider()

            Text(
                text = "Change Language",
                style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h1.fontSize,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }
    }

}

@Composable
internal fun AsyncImage(url: String, modifier: Modifier) {
    val painter = rememberAsyncImagePainter(url = url)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
    when (val requestState = painter.requestState) {
        ImageRequestState.Loading -> {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ImageRequestState.Failure -> {
            Text(requestState.error.message ?: "Error")
        }
        ImageRequestState.Success -> Unit
    }
}
