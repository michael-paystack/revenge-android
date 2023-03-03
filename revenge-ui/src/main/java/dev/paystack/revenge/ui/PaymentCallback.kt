package dev.paystack.revenge.ui

interface PaymentCallback {
    fun onSuccess(transactionId: String)

    fun onError(message: String)
}