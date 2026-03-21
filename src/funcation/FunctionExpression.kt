package funcation

enum class TransactionType {
    FUND_TRANSFER,
    BUlk_TRANSFER,
}

fun main() {
    val firstName: String = "Ouch"
    val lastName: String = "Sivutha"

    val fullName = "$firstName $lastName"
}

fun getElementById(id: String) {
    val value = if (id.isEmpty()) "home_id" else id
}


fun getTotalAmount(a: Double, b: Double): Double {
    return a + b
}

fun getFree(transactionType: TransactionType): Double = when (transactionType) {
    TransactionType.BUlk_TRANSFER -> 200.00
    TransactionType.FUND_TRANSFER -> 100.0
}

fun combineFirstNameLastName(firstName: String, lastName: String): String = "$firstName $lastName"

/**
 * - Practice function expression + if expression and function expression + when expression
 *
 */


















