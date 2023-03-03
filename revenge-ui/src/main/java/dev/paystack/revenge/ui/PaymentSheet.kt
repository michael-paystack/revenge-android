package dev.paystack.revenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.paystack.revenge.core.PaymentResult
import dev.paystack.revenge.core.PaymentStatus

@Composable
internal fun PaymentSheet(onPaymentResult: (PaymentResult) -> Unit) {
    Surface {
        CardCheckoutForm(
            currency = "NGN",
            amount = 458000,
            onPaymentResult = onPaymentResult
        )
    }
}


@Composable
private fun CardCheckoutForm(
    currency: String,
    amount: Long,
    onPaymentResult: (PaymentResult) -> Unit,
    modifier: Modifier = Modifier
) {
    var cardNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<PaymentResult?>(null) }

    LaunchedEffect(result) {
        result?.let { onPaymentResult(it) }
    }

    Column(modifier = modifier.padding(16.dp)) {

        TextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text(text = "Card number") },
            placeholder = { Text(text = "0000 0000 0000 0000") },
            modifier = Modifier.fillMaxWidth(),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Card expiry") },
                placeholder = { Text(text = "MM / YY") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "CVV") },
                placeholder = { Text(text = "123") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { result = PaymentResult(PaymentStatus.success, "transx_id") },
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pay $currency ${amount.div(100)}")
        }
    }
}