package oops

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


data class TransactionModel(
    val transactionId: String,
    val senderName: String,
    val senderAccountNo: String,
    val receiverAccountName: String,
    val receiverAccountNo: String,
    val transactionDate: String, // yyyyMMdd -> Example 20260208,
    val transactionAmount: Double,
    val transactionCurrency: String,
    val transactionType: String,  // Bankong, Fund Transfer, Bulk Transafer, TopUp, International fun transfer
    val debitAmount: Double, // outgoing amount
    val creditAmount: Double, // incoming amount
)

/**
 * Primary constructor
 */
class Person(val name: String, val ages: Int = 0, val dob: String) {

    init {
        println(dob)
    }

    /**
     * Convert DOB from yyyyMMdd to MMM dd, yyyy
     * Example: 20200101 -> Jan 01, 2020
     */
    fun getFullInfo(): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)

        val date = LocalDate.parse(dob, inputFormatter)
        return "$name was born on ${date.format(outputFormatter)}"
    }
}

class Account {
    var transactions: List<TransactionModel> = emptyList()

    init {
        getAccountList()
    }

    private fun getAccountList() {
        transactions = transactionList
    }
}


fun main() {
    val sok = Person(name = "Sok Sabay", dob = "20200101")
    val account = Account()
    println(account.transactions)

}

val transactionList = listOf(
    TransactionModel(
        transactionId = "TXN0001",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Sok Dara",
        receiverAccountNo = "009876543210",
        transactionDate = "20260201",
        transactionAmount = 150.00,
        transactionCurrency = "USD",
        transactionType = "Fund Transfer",
        debitAmount = 150.00,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0002",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Electricity Cambodia",
        receiverAccountNo = "EAC000112233",
        transactionDate = "20260202",
        transactionAmount = 45.50,
        transactionCurrency = "USD",
        transactionType = "Banking",
        debitAmount = 45.50,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0003",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Smart Axiata",
        receiverAccountNo = "SMART098765",
        transactionDate = "20260202",
        transactionAmount = 10.00,
        transactionCurrency = "USD",
        transactionType = "TopUp",
        debitAmount = 10.00,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0004",
        senderName = "Sok Dara",
        senderAccountNo = "009876543210",
        receiverAccountName = "Buon Pheaktra",
        receiverAccountNo = "001234567890",
        transactionDate = "20260203",
        transactionAmount = 500.00,
        transactionCurrency = "USD",
        transactionType = "Fund Transfer",
        debitAmount = 0.0,
        creditAmount = 500.00
    ),
    TransactionModel(
        transactionId = "TXN0005",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "AEON Mall Phnom Penh",
        receiverAccountNo = "AEON778899",
        transactionDate = "20260204",
        transactionAmount = 120.75,
        transactionCurrency = "USD",
        transactionType = "Banking",
        debitAmount = 120.75,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0006",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Global Trading Ltd",
        receiverAccountNo = "INTL445566",
        transactionDate = "20260205",
        transactionAmount = 1000.00,
        transactionCurrency = "USD",
        transactionType = "International Fund Transfer",
        debitAmount = 1000.00,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0007",
        senderName = "Payroll System",
        senderAccountNo = "PAYROLL001",
        receiverAccountName = "Buon Pheaktra",
        receiverAccountNo = "001234567890",
        transactionDate = "20260206",
        transactionAmount = 800.00,
        transactionCurrency = "USD",
        transactionType = "Bulk Transfer",
        debitAmount = 0.0,
        creditAmount = 800.00
    ),
    TransactionModel(
        transactionId = "TXN0008",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Water Supply Phnom Penh",
        receiverAccountNo = "WATER334455",
        transactionDate = "20260206",
        transactionAmount = 25.30,
        transactionCurrency = "USD",
        transactionType = "Banking",
        debitAmount = 25.30,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0009",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverAccountName = "Online Shop KH",
        receiverAccountNo = "SHOP112233",
        transactionDate = "20260207",
        transactionAmount = 65.99,
        transactionCurrency = "USD",
        transactionType = "Fund Transfer",
        debitAmount = 65.99,
        creditAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN0010",
        senderName = "ABA Bank Saving",
        senderAccountNo = "SAV998877",
        receiverAccountName = "Buon Pheaktra",
        receiverAccountNo = "001234567890",
        transactionDate = "20260208",
        transactionAmount = 300.00,
        transactionCurrency = "USD",
        transactionType = "Banking",
        debitAmount = 0.0,
        creditAmount = 300.00
    )
)


/**
 * ======> February 07, 2026 <======
 * Homework Related inline function and no inline including OOP
 * 1. Testing inline and noinline function (Find any topic for testing)
 * 2. Create a class related to financial industry (Account, Transaction)
 * 3. Create instance
 * 4. Apply primary constructor (Example transactionTypeCode: String)
 * 5. Convert code to real info of you primary construct in init block
 *      Example: Convert transaction typeCode to name
 *          - 01: Bakong
 *          - 02: Fund Transfer
 */

/**
 * ======> February 08, 2026 <======
 * 1. Topic : Research related account transaction in banking application
 * 2. Create account class that contain multiple constructor
 * 3. Create 2 class:
 *      - Account
 *      - Transaction
 * 4. Create subclass from Account and Transaction
 * 5. Apply encapsulation concept into class above (Account and Transaction)
 *      - public
 *      - private
 *      - protected
 * 6. Add getter and setter member into the class to modify private member.
 */