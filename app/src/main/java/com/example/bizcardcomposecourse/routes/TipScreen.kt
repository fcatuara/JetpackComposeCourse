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
import androidx.compose.runtime.mutableDoubleStateOf
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
import kotlin.math.roundToInt

const val MIN_DIVISOR = 1

@Composable
fun TipScreen(modifier: Modifier = Modifier) {
    val totalPerPersonState = remember { mutableDoubleStateOf(0.0) }
    Column(
        modifier = modifier.padding(18.dp),
    ) {
        TopHeader(modifier = modifier,totalPerPersonState.doubleValue)
        BillForm(modifier = modifier, onValueChange = {
            println("onValueChange: $it")
            totalPerPersonState.doubleValue = it
        })
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

@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValueChange: (Double) -> Unit = {},
    forceShowContent: Boolean = false
) {
    val totalBillState = remember { mutableStateOf("") }
    val hasInputFieldValue = totalBillState.value.trim().isNotEmpty()

    val splitState = remember { mutableStateOf(MIN_DIVISOR.toString()) }
    val sliderPositionState = remember { mutableFloatStateOf(0f) }
    val tipAmountState = remember { mutableDoubleStateOf(0.0) }

    val tipPercentage = sliderPositionState.floatValue.roundToInt()
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        println("recompose surface")
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
                    onValueChange(totalBillState.value.trim().toDouble())
                    /*totalPerPersonState.doubleValue = calculateTotalPerPerson(
                        splitBy = splitState.value.toInt(),
                        totalBill = totalBillState.value.toDouble()
                    )*/
                    keyboardController?.hide()
                })
            if (hasInputFieldValue || forceShowContent) {
                Row(
                    modifier = Modifier.padding(3.dp),
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
                            if (splitState.value.toInt() > MIN_DIVISOR) splitState.value =
                                (splitState.value.toInt() - 1).toString()
                        })
                        Text(
                            text = splitState.value,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )
                        RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                            splitState.value = (splitState.value.toInt() + 1).toString()
                            /*totalPerPersonState.value = calculateTotalPerPerson(
                                splitBy = splitState.value.toInt() + 1,
                                totalBill = 4,
                                tipAmount = 6
                            )*/
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
                        text = "$ ${tipAmountState.doubleValue}",
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

                    /**
                     * Example to understand recomposition:
                     *
                     * val sliderValue = remember { mutableFloatStateOf(0f) }
                     * Text("Valore: ${sliderValue.floatValue}") // <-- depends on the sliderValue
                     *
                     * Slider(
                     *     value = sliderValue.floatValue,
                     *     onValueChange = { sliderValue.floatValue = it }
                     * )
                     *
                     * 1. sliderValue.floatValue change inside the onValueChange lambda
                     * 2. Text() depends on that value
                     * 3. Compose recomposes Text()
                     *
                     */
                    Text(text = "${tipPercentage}%")
                    Slider(value = sliderPositionState.floatValue,
                        onValueChange = { newValue ->
                            sliderPositionState.floatValue = newValue
                            tipAmountState.doubleValue = calculateTotalTip(
                                totalBillState.value.toDouble(), newValue.roundToInt()
                            )
                            /*totalPerPersonState.doubleValue = calculateTotalPerPerson(
                                splitBy = splitState.value.toInt(),
                                totalBill = totalBillState.value.toDouble(),
                                tipPercentage = newValue.roundToInt()
                            )*/
                        },
                        modifier = Modifier.padding(horizontal = 16.dp),
                        steps = 9,
                        valueRange = 0f..100f,
                        onValueChangeFinished = {
                        })
                }
            } else {
                Box {}
            }
        }
    }
}

fun calculateTotalTip(
    totalBill: Double, tipPercentage: Int
) = if (totalBill > 1.0 && totalBill.toString().isNotEmpty())
    (totalBill * tipPercentage) / 100
else 0.0

fun calculateTotalPerPerson(
    totalBill: Double,
    splitBy: Int,
    tipPercentage: Int
): Double {
    val bill = 
        calculateTotalTip(totalBill = totalBill, tipPercentage = tipPercentage) + totalBill
    return bill / splitBy
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

@Preview(showBackground = true)
@Composable
fun TipScreenPreview() {
    TipScreen()
}