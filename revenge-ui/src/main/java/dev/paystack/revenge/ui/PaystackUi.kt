package dev.paystack.revenge.ui

import android.app.Activity
import dev.paystack.revenge.core.PaymentStatus

object PaystackUi {
    fun launchPaymentSheet(
        activity: Activity,
        accessCode: String,
        paymentCallback: PaymentCallback
    ) {
        activity.showAsBottomSheet { closeSheet ->
            PaymentSheet { result ->
                when (result.status) {
                    PaymentStatus.success -> paymentCallback.onSuccess(result.transactionId)
                    else -> paymentCallback.onError("Error here")
                }
                closeSheet()
            }
        }
    }
}
