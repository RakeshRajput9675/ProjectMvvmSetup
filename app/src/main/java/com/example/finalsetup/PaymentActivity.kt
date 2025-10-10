package com.example.finalsetup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class PaymentActivity : ComponentActivity(), PaymentResultWithDataListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Checkout.preload(applicationContext)

        startRazorpayPayment()
    }

    private fun startRazorpayPayment() {
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_1DP5mmOlF5G5ag")
        try {
            val options = JSONObject().apply {
                put("name", "Your Company")
                put("description", "Test Payment via Compose")
                put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
                put("currency", "INR")
                put("amount", "100")

                val prefill = JSONObject().apply {
                    put("email", "test@razorpay.com")
                    put("contact", "9999999999")
                }
                put("prefill", prefill)
            }

            checkout.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {

        Toast.makeText(this, "Payment Success: $p0", Toast.LENGTH_LONG).show()
    }

    override fun onPaymentError(code: Int, description: String?, paymentData: PaymentData?) {
        Toast.makeText(this, "Payment Failed: $description", Toast.LENGTH_LONG).show()
    }
}
