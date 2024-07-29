package com.example.bizcardcomposecourse.routes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DollarCounterScreen(modifier: Modifier) {
    Surface(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(), color = Color.Magenta
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$100",
                color = Color.Black,
                style = TextStyle(color = Color.Black, fontSize = 30.sp)
            )
            Spacer(modifier = Modifier.height(130.dp))
            CircleCardScreen()
        }
    }
}

@Composable
fun CircleCardScreen() {
    /**first implementation that doesn't work*/
    //var moneyCounter = 0
    var moneyCounter by remember { mutableIntStateOf(0) }
    /**
     * Value Preservation: `remember` is used to instruct Compose to retain an object or value across recompositions.
     * This is useful because in a declarative approach, composable functions can be recreated frequently and without `remember`,
     * we would lose the value of our state with each recomposition.
     *
     * Efficiency: Without `remember`, every time a composable is recreated, it would reinitialize its state,
     * which is not efficient and can lead to undesirable behavior. `remember` ensures that the state value is preserved
     * throughout the UI's lifecycle, but it is initialized only the first time the composable is created.
     *
     * Example Usage:
     *
     * var moneyCounter by remember { mutableIntStateOf(0) }
     *
     * In the provided example:
     * - `mutableIntStateOf(0)` creates a mutable integer state initialized to 0.
     * - `remember` tells Compose to remember this state across recompositions,
     *   ensuring that the counter maintains its current value and is not reset to 0 every time the composable is recreated.
     *
     * Summary:
     * Compose requires mutable state and `remember` to:
     * - Correctly manage data changes and update the UI accordingly.
     * - Preserve the state across recompositions, ensuring efficient and predictable behavior of the UI.
     *
     * This state management is key to fully leveraging the declarative paradigm of Jetpack Compose.
     */

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(145.dp)
            .clickable { moneyCounter += 1 },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
        ) {
            /**
             * Clicking the button you won't see the moneyCounter value updated:
             * that's because whenever we want to change something inside of a
             * composable function (in this case a Text), we need to redraw that composable
             *
             * That's the difference between the imperative approach and the declarative
             * approach: In the declarative approach we are passing data through the composable
             * function, and the composable function reacts to that data
             *
             * So how we make this text reacts to that data? (which in this case means to redraw itself)
             * We are talking about Recomposition.
             */
            Text(
                text = "Tap $moneyCounter", style = TextStyle(
                    color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DollarCounterScreenPreview() {
    DollarCounterScreen(modifier = Modifier.padding(0.dp))
}