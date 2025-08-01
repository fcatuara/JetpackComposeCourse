package com.example.bizcardcomposecourse.experiments.portfolio

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bizcardcomposecourse.R

@Composable
fun PortfolioScreen(modifier: Modifier) {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage(
                    modifier = Modifier
                        .size(160.dp)
                        .padding(16.dp)
                )
                HorizontalDividerWithSpacer(space = 20.dp)
                InfoSection()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(text = "Portfolio")
                }

                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box {}
                }
            }
        }
    }
}

/**
 * Box: Does not have predefined styles. It is a basic container for positioning elements on top of each other.
 *
 * Surface: Provides predefined material styles such as background color, elevation, rounded corners, etc.
 * It is ideal for creating styled components according to the Material Design system.
 */

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(size = 6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            PortfolioList(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4",
                    "Project 5",
                    "Project 6",
                    "Project 7",
                    "Project 8",
                )
            )
        }
    }
}

/**
 * How do we create a scrollable list in Compose? With LazyColum
 * You get the scroll ability
 * You get the advantage of recyclable views
 *
 * LazyColumn will know how to recycle the views as they are being displayed
 */
@Composable
fun PortfolioList(data: List<String>) {
    LazyColumn {
        items(data) { project ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                RowContent(project)
            }
        }
    }
}

@Composable
private fun RowContent(project: String) {
    Row {
        ProfileImage(
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp)
        )
        Column(
            modifier = Modifier
                .padding(7.dp)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Text(text = project, fontWeight = FontWeight.Bold)
            Text(text = "A great project", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
private fun InfoSection() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles.P",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(1.dp)
        )
        Text(
            text = "@themilesCompose",
            modifier = Modifier.padding(1.dp)
        )
    }
}

@Composable
private fun HorizontalDividerWithSpacer(space: Dp = 0.dp) {
    Spacer(modifier = Modifier.height(space))
    HorizontalDivider(
        color = DividerDefaults.color,
        thickness = DividerDefaults.Thickness,
    )
    Spacer(modifier = Modifier.height(space))
}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
        shadowElevation = 4.dp,
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PortfolioScreenPreview() {
    PortfolioScreen(modifier = Modifier.padding(4.dp))
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}