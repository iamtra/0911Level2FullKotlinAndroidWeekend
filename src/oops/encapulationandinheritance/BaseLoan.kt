package oops.encapulationandinheritance

import java.math.BigDecimal
import java.time.LocalDate

enum class LoanStatus {
    PENDING,
    ACTIVE,
    OVERDUE,
    CLOSED
}

open class BaseLoan(

    // Identity (immutable)
    val loanId: String,
    val customerId: String,

    // Financial (encapsulated)
    principalAmount: BigDecimal,
    interestRate: Double,
    tenureInMonths: Int,

    // Dates
    val startDate: LocalDate,

    // Status
    status: LoanStatus
) {

    // --- Encapsulated fields ---
    private var _principalAmount: BigDecimal = principalAmount
    private var _interestRate: Double = interestRate
    private var _tenureInMonths: Int = tenureInMonths

    private var _status: LoanStatus = status

    protected val monthlyInterestRate: Double
        get() = _interestRate / 12 / 100

    val createdAt: LocalDate = LocalDate.now()
    private var updatedAt: LocalDate = LocalDate.now()

    // --- Controlled getters ---
    open fun getPrincipalAmount(): BigDecimal = _principalAmount
    open fun getInterestRate(): Double = _interestRate
    open fun getTenureInMonths(): Int = _tenureInMonths
    fun getStatus(): LoanStatus = _status
    fun getUpdatedAt(): LocalDate = updatedAt

    // --- Controlled setters (business rules) ---
    open fun updateInterestRate(newRate: Double) {
        require(newRate > 0) { "Interest rate must be positive" }
        _interestRate = newRate
        touch()
    }

    open fun updateTenure(months: Int) {
        require(months > 0) { "Tenure must be greater than zero" }
        _tenureInMonths = months
        touch()
    }

    protected fun updatePrincipal(amount: BigDecimal) {
        require(amount > BigDecimal.ZERO) { "Principal must be positive" }
        _principalAmount = amount
        touch()
    }

    open fun updateStatus(newStatus: LoanStatus) {
        _status = newStatus
        touch()
    }

    // --- Common behaviors ---
    open fun calculateMonthlyInstallment(): BigDecimal {
        val r = monthlyInterestRate
        val n = _tenureInMonths

        val emi = _principalAmount.toDouble() *
                r * Math.pow(1 + r, n.toDouble()) /
                (Math.pow(1 + r, n.toDouble()) - 1)

        return BigDecimal.valueOf(emi)
    }

    open fun calculateTotalPayable(): BigDecimal =
        calculateMonthlyInstallment()
            .multiply(BigDecimal.valueOf(_tenureInMonths.toLong()))

    open fun closeLoan() {
        _status = LoanStatus.CLOSED
        touch()
    }

    open fun isActive(): Boolean =
        _status == LoanStatus.ACTIVE

    private fun touch() {
        updatedAt = LocalDate.now()
    }
}


//class CarLoan(
//    loanId: String,
//    customerId: String,
//    principalAmount:
//    BigDecimal,
//    interestRate: Double,
//    tenureInMonths: Int,
//    startDate: LocalDate,
//    status: LoanStatus
//) : BaseLoan(loanId, customerId, principalAmount, interestRate, tenureInMonths, startDate, status) {
//    override fun calculateMonthlyInstallment(): BigDecimal {
//        // Logic here
//        return BigDecimal("1023030.00")
//    }
//}


data class LoanModel(
    val loanType: String
) {
    private fun convertLoanType() : String {
        return  "Car Loan"
    }

    fun convertLoanCodeToValue() = convertLoanType()
}

fun main() {
    val loanCar = LoanModel(
        loanType = "01"
    )

    val loanType = loanCar.convertLoanCodeToValue()
}

/**
 * Homework February 22, 2026
 * Topic: Secondary constructor, encapulation and inheritance and also research about OOP
 * 1. Create class and apply the secondary constructor
 * 2. Create a small loan class and apply both encapulation and inheritance
 * 3. Crate subclass and inherit from loan class
 *      - CarLoan
 *      - SamsungLoan
 *      - HouseLoan
 *      - .......
 */