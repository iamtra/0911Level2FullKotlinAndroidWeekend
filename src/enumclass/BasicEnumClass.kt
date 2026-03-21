package enumclass

import oops.`object`.Payment


/**
 * Enum class without any constructor
 */
enum class PaymentType {
    BAKONG_TRANSFER,
    NSC_TRANSFER,
    LOCAL_BANK_TRANSFER,
    FUND_TRANSFER,
    BULK_TRANSFER,
    INTERNATIONAL_FUN_TRANSFER,
}


/**
 * Enum class that contain constructor
 */
enum class NetworkError(val code: String, val message: String) {
    SERVER_NOT_FOUND(code = "404", message = "Server not found")
}

fun main() {
    checkPaymentType(PaymentType.FUND_TRANSFER)

    val code: String = "404"
    val message = handleNetworkError(code = code)
    println(message)
}

fun checkPaymentType(payment: PaymentType) {
    when (payment) {
        PaymentType.BULK_TRANSFER -> {

        }

        PaymentType.BAKONG_TRANSFER -> {

        }

        PaymentType.NSC_TRANSFER -> {

        }

        PaymentType.LOCAL_BANK_TRANSFER -> {

        }

        PaymentType.FUND_TRANSFER -> {

        }

        else -> {

        }
    }
}


fun handleNetworkError(code: String): String {
    return when (code) {
        NetworkError.SERVER_NOT_FOUND.code -> {
            NetworkError.SERVER_NOT_FOUND.message
        }

        else -> {
            ""
        }
    }
}







