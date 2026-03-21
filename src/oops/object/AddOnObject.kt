package oops.`object`

abstract class Payment {
    abstract fun onPay()
}

/**
 * Object declaration
 */
object PaymentMethod {
    fun onPay() {

    }
}

fun main() {
    /**
     * Anonymous object
     */
    val payment = object : Payment() {
        override fun onPay() {

        }
    }

    PaymentMethod.onPay()

    payment.onPay()
}