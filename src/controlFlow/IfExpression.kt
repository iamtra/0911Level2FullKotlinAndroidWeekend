package controlFlow


fun main() {
    val transactionAmount = 400000.0
    getFree(transactionAmount)
}

fun getDrink(value: String): String {
    return if (value == "Latte") {
        "Latte"
    } else {
        "Macha"
    }
}

fun getDrink1(value: String): String {
    return "Latte"
}

/**
 * Oversea transfer (International fun transfer)
 * - Less than 1000 USD not fee charge
 * - Greater than 1000 .. 10000 fee charge 12USD
 * - Greater than 10000 .. 100000 fee charge 24 USD
 * - Greater than 100000 .. 500000 fee charge 40USD
 */
fun getFree(transactionAmount: Double) {
    // When statement
    var fee = 0
    when (transactionAmount) {
        in 0.0..1000.0 -> {
            fee = 0
        }

        in 1000.1..10000.0 -> {
            fee = 12
        }

        in 10000.1..100000.0 -> {
            fee = 24
        }

        in 100000.1..500000.0 -> {
            fee = 40
        }

        else -> {
            println("Transaction amount is over limit")
        }
    }

    println("Fee charge is $fee")
}

fun getFreeUsingWhenExpression(transactionAmount: Double) {
    // When statement
    val fee = when (transactionAmount) {
        in 0.0..1000.0 -> 0

        in 1000.1..10000.0 -> 12

        in 10000.1..100000.0 -> 24

        in 100000.1..500000.0 -> 40

        else -> println("Transaction amount is over limit")
    }

    println("Fee charge is $fee")
}









