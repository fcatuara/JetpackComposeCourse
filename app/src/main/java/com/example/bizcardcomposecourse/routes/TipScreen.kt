package com.example.bizcardcomposecourse.routes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardcomposecourse.components.InputField
import com.example.bizcardcomposecourse.widgets.RoundIconButton

@Composable
fun TipScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(18.dp),
    ) {
        TopHeader(modifier = modifier)
        MainContent()
    }
}

@Composable
fun TopHeader(modifier: Modifier = Modifier, totalPerPerson: Double = 0.0) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))), color = Color(0xFFE9D7F7)
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            println("recompose top header")
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total per Person", style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "$$total",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}


/**
 * In an experiment using delegation without a state flow, similar results were
 * achieved, but a callback was required in the InputField composable to update
 * totalBillState and trigger the recomposition of the MainContent.
 *
 * e.g: var totalBillState by remember { mutableStateOf("") } (that returns an Int and not a state)
 */
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    BillForm(modifier = modifier)
}


@Composable
fun BillForm(
    modifier: Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val totalBillState = remember { mutableStateOf("") }
    val hasInputFieldValue = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            InputField(valueState = totalBillState,
                labelId = "Enter bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!hasInputFieldValue) return@KeyboardActions
                    onValueChange(totalBillState.value.trim())
                    keyboardController?.hide()
                })
            if (hasInputFieldValue) {
                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    Row {
                        RoundIconButton(imageVector = Icons.Default.Remove, onClick = { })
                        RoundIconButton(imageVector = Icons.Default.Add, onClick = { })
                    }
                }
            } else {
                Box {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    MainContent()
}

@Preview(showBackground = true)
@Composable
fun TopHeaderPreview() {
    TopHeader()
}

//@Preview(showBackground = true)
@Composable
fun TipScreenPreview() {
    TipScreen()
}