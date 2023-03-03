package dev.paystack.revenge.example

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.paystack.revenge.ui.PaymentCallback
import dev.paystack.revenge.ui.PaystackUi

class ViewsActivity : AppCompatActivity() {
    private val paymentCallback = object : PaymentCallback {
        override fun onSuccess(transactionId: String) {
            Toast.makeText(this@ViewsActivity, "Success: $transactionId", Toast.LENGTH_SHORT)
                .show()
        }

        override fun onError(message: String) {
            Toast.makeText(this@ViewsActivity, "Success: $message", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        findViewById<Button>(R.id.payBtn).setOnClickListener {
            PaystackUi.launchPaymentSheet(this, "access_code", paymentCallback)
        }
    }
}