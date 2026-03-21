package oops.encapulationandinheritance

/**
 * Parent class
 */
open class Loan {
    /**
     * Public allow all access
     */
    var loanId: String = "030303"

    /**
     * Private is used by internal member
     */
    private var borrowerName = ""

    /**
     * Protect : Only internal member and subclass, but instant cannot be accessed
     */
    protected var borrowAmount: Double = 0.0

    fun assignBorrowerName(name: String) {
        borrowerName = name
    }
}

/**
 * Subclass or child class
 */
class CarLoan : Loan() {

    fun update(name: String, amount: Double) {
        this.loanId = "575757575"
        this.borrowAmount = amount
    }
}

fun main() {
    val loan1 = Loan()
    loan1.loanId = "3562353543"
}

/**
 * Apply loan business infomation
 */