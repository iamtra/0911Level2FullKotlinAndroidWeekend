package oops.operatoroverloading

/**
 * Minus -
 * Plus +
 * divide /
 * Multiply *
 */
data class LoanAccount(
    val principleAmount: Double,
    val interestAmount: Double,
) {
    operator fun plus(other: LoanAccount): LoanAccount {
        return LoanAccount(
            principleAmount = principleAmount + other.principleAmount,
            interestAmount = interestAmount + other.interestAmount
        )
    }

    operator fun minus(other: LoanAccount): LoanAccount {
        return LoanAccount(
            principleAmount = principleAmount - other.principleAmount,
            interestAmount = interestAmount - other.interestAmount
        )
    }

}

fun LoanAccount.formatCurrency(): String {
    return "${this.interestAmount}USD"
}


fun main() {
    val loan1 = LoanAccount(principleAmount = 25000.0, interestAmount = 100.0)
    val loan2 = LoanAccount(principleAmount = 10000.0, interestAmount = 500.0)

    val loan5 = LoanAccount(
        principleAmount = loan1.principleAmount,
        interestAmount = loan2.interestAmount
    )

    val loan6 = loan1.copy(interestAmount = 3763734.0)


    /**
     * Plus without using operator overloading
     */
    val loan3 = LoanAccount(
        principleAmount = loan1.principleAmount + loan2.principleAmount,
        interestAmount = loan1.interestAmount + loan2.interestAmount
    )

    /**
     * plus object operator overloading
     */
    val result = loan1.plus(loan2)

    /**
     * Minus without using operator overloading
     */
    val loan7 = LoanAccount(
        principleAmount = loan1.principleAmount - loan2.principleAmount,
        interestAmount = loan1.interestAmount - loan2.interestAmount
    )

    /**
     * Minus with operator overloading
     */
    val minusLoan = loan1.minus(loan2)

    val (_, interestAmount) = minusLoan

    val loanList = listOf(loan1, loan2, loan3)

//    for ((_, interestAmount) in loanList) {
//        println(interestAmount)
//    }

    println(loan1.formatCurrency())


}

/**
 * Practice data class with Transfer
 *  1. Create Transaction Model
 *  2. Apply Operator overloading
 *  3. Test destructure object from transaction
 *  4. Create a Transaction List
 *  5. Loop transactionList and destructure some of property
 *  6. Add extension to for display some info by the following below instruction
 *      - Format currency base on KHR and USD
 *      - format transaction date time
 *      - and do research more
 */