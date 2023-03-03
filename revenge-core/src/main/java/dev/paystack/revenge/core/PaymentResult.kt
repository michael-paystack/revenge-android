package dev.paystack.revenge.core

data class PaymentResult(
    val status: PaymentStatus,
    val transactionId: String
)

enum class PaymentStatus {
    unknown,
    success,
    failed,
    ongoing,
    requery
}