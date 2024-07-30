package com.example.bizcardcomposecourse.routes

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

const val MIN_DIVISOR = 2

@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    forceShowContent: Boolean = false
) {
    val totalBillState = remember { mutableStateOf("") }
    val hasInputFieldValue = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val splitValue = remember { mutableStateOf(MIN_DIVISOR.toString()) }
    val sliderPositionState = remember { mutableFloatStateOf(0f) }
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
            if (hasInputFieldValue || forceShowContent) {
                Row(
                    modifier = Modifier
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = "Split",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    Row {
                        RoundIconButton(imageVector = Icons.Default.Remove, onClick = {
                            if (splitValue.value.toInt() > MIN_DIVISOR)
                                splitValue.value = (splitValue.value.toInt() - 1).toString()
                        })
                        Text(
                            text = splitValue.value,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )
                        RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                            splitValue.value = (splitValue.value.toInt() + 1).toString()
                        })
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 3.dp, vertical = 12.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Tip",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .weight(1f)
                    )
                    Text(
                        text = "Tip",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "33%")
                    Slider(value = sliderPositionState.floatValue, onValueChange = { newValue ->
                        sliderPositionState.floatValue = newValue
                        println("slider position: $newValue")
                    })
                }
            } else {
                Box {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BillFormPreview() {
    BillForm(forceShowContent = true)
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