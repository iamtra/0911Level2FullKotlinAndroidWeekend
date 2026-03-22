package enumclass


enum class AccountTypeCode(val code: String) {
    SAVING_ACCOUNT("01"),
    DEPOSIT_ACCOUNT("02"),
    JUNIOR_ACCOUNT("03"),
    CURRENT_ACCOUNT("04"),
    LOAN_ACCOUNT("05"),
}

data class BankAccountModel(
    val accountId: String,
    val accountNumber: String,
    val accountHolderName: String,
    val bankName: String,
    val branchName: String? = null,
    val balance: Double,
    val currency: String = "USD",
    val accountType: String, // 01, 02, 03, 04, 05
    val isActive: Boolean = true,
    val createdAt: Long,
    val updatedAt: Long? = null
)

fun String.toAccountType(): String {
    return when (this) {
        AccountTypeCode.SAVING_ACCOUNT.code -> "Saving"
        AccountTypeCode.DEPOSIT_ACCOUNT.code -> "Deposit"
        AccountTypeCode.JUNIOR_ACCOUNT.code -> "Junior"
        AccountTypeCode.CURRENT_ACCOUNT.code -> "Current"
        AccountTypeCode.LOAN_ACCOUNT.code -> "Loan"
        else -> "Unknown"
    }
}

fun BankAccountModel.onReport() {
    val accountInfo = """
        Account ID:             $accountId
        AccountNumber:          $accountNumber
        Account Holder Name:    $accountHolderName
        Account Type:           ${accountType.toAccountType()}      
        Bank Name:              $bankName
        Branch Name:            $branchName
        Account Balance:        $balance $currency
        Active Status:          ${if (isActive) "active" else "inactive"}
        Created At:             $createdAt
        Updated At:             $updatedAt
    """.trimIndent()

    println(accountInfo)
}

/**
 * It is a backend data
 */
val accountList = mutableListOf(
    BankAccountModel(
        accountId = "01",
        accountHolderName = "machalate",
        accountNumber = "100999888",
        bankName = "ABA Bank",
        branchName = "Phnom Penh",
        balance = 2000000.0,
        currency = "KHR",
        accountType = "01",
        isActive = true,
        createdAt = 202603220948,
        updatedAt = 202603220948,
    ),
    BankAccountModel(
        accountId = "02",
        accountHolderName = "sokha",
        accountNumber = "200888777",
        bankName = "ACLEDA Bank",
        branchName = "Phnom Penh",
        balance = 1500000.0,
        currency = "KHR",
        accountType = "02",
        isActive = true,
        createdAt = 202603220950,
        updatedAt = 202603220950,
    ),
    BankAccountModel(
        accountId = "03",
        accountHolderName = "dara",
        accountNumber = "300777666",
        bankName = "Canadia Bank",
        branchName = "Siem Reap",
        balance = 5000000.0,
        currency = "USD",
        accountType = "01",
        isActive = true,
        createdAt = 202603220955,
        updatedAt = 202603220955,
    ),
    BankAccountModel(
        accountId = "04",
        accountHolderName = "vannak",
        accountNumber = "400666555",
        bankName = "Wing Bank",
        branchName = "Battambang",
        balance = 750000.0,
        currency = "KHR",
        accountType = "03",
        isActive = false,
        createdAt = 202603221000,
        updatedAt = 202603221000,
    ),
    BankAccountModel(
        accountId = "05",
        accountHolderName = "lina",
        accountNumber = "500555444",
        bankName = "ABA Bank",
        branchName = "Phnom Penh",
        balance = 3200.0,
        currency = "USD",
        accountType = "02",
        isActive = true,
        createdAt = 202603221005,
        updatedAt = 202603221005,
    )
)


fun main() {
    for (item in accountList) {
        item.onReport()
        println("=========================================")
    }
}
