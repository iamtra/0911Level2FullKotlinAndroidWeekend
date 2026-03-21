package oops.extension

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class BankAccount(
    val accountNumber: String,   // Unique account number 9 digit
    val accountHolder: String,   // Name of the account owner
    val balance: Double,         // Current balance
    val currency: String,        // Currency code, e.g., "USD", "KHR"
    val accountType: AccountType,// Savings, Checking, etc.
    val isActive: Boolean = true, // Account status
    val transactionDate: String // YYYYmmDD 20260228
)

fun String.displayDate() : String {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val date = LocalDate.parse(this, formatter)

    val outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
    val formattedDate = date.format(outputFormatter)

    return formattedDate
}

fun BankAccount.maskAccountNo(): String {
    return "*****${accountNumber.takeLast(4)}"
}

// Enum for account type
enum class AccountType {
    SAVINGS,
    CHECKING,
    BUSINESS
}

enum class CardType {
    DEBIT,
    CREDIT,
    PREPAID
}

enum class CardNetwork {
    VISA,
    MASTERCARD,
    JCB,
    UNIONPAY
}

enum class CardStatus {
    ACTIVE,
    BLOCKED,
    EXPIRED,
    SUSPENDED
}

data class Card(
    // Identification
    val cardId: String,
    val cardNumber: String,

    // Card holder
    val cardHolderName: String,
    val holderCustomerId: String,

    // Card details
    val cardType: CardType,          // DEBIT / CREDIT / PREPAID
    val cardNetwork: CardNetwork,    // VISA / MASTER / JCB / UNIONPAY
    val expiryDate: String,           // MM/YY
    val issueDate: LocalDate,

    // Financial info
    val availableBalance: Double,
    val currentBalance: Double,
    val creditLimit: Double? = null,  // Only for credit cards
    val currency: String = "USD",

    // Status & security
    val cardStatus: CardStatus,
    val isContactlessEnabled: Boolean,
    val isOnlinePaymentEnabled: Boolean,
    val isInternationalPaymentEnabled: Boolean,

    // Metadata
    val createdAt: LocalDate,
    val lastUsedAt: LocalDate? = null
)

fun Card.maskCardNo() : String {
    return "${cardNumber.take(4)} **** **** ${cardNumber.takeLast(4)}"
}

fun main() {
    val bankAccount = BankAccount(
        accountNumber = "123456789",
        accountType = AccountType.BUSINESS,
        accountHolder = "Pheaktra",
        isActive = true,
        currency = "KHR",
        balance = 10000.0,
        transactionDate = "20260228" // February 28, 2026
    )

    val card = Card(
        cardId = "CARD-001",
        cardNumber = "4111111111111111",
        cardHolderName = "Buon Pheaktra",
        holderCustomerId = "CUST-1001",
        cardType = CardType.DEBIT,
        cardNetwork = CardNetwork.VISA,
        expiryDate = "12/28",
        issueDate = LocalDate.of(2024, 1, 10),
        availableBalance = 1500.75,
        currentBalance = 1500.75,
        creditLimit = null,
        currency = "USD",
        cardStatus = CardStatus.ACTIVE,
        isContactlessEnabled = true,
        isOnlinePaymentEnabled = true,
        isInternationalPaymentEnabled = false,
        createdAt = LocalDate.now(),
        lastUsedAt = null
    )

    println(card.maskCardNo())
}