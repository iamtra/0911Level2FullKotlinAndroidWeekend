package oops

import oops.data.Transaction
import oops.data.TransactionStatus
import oops.data.transactionList

enum class TransactionStatus {
    PENDING,
    SUCCESS,
    FAILED
}


interface NewBankAccount {
    val accountName: String
    val accountNo: String
    val accountType: String
    val currencyCode: String

    fun onFreeze()
    fun onTransfer()
    fun getTransactionList(): List<Transaction>
    fun getAccountTransactionHistory(receiverAccountNo: String): List<Transaction>
    fun filterTransaction(status: TransactionStatus, onResult: (list: List<Transaction>) -> Unit)
}

class SavingAccount(
    override val accountName: String,
    override val accountNo: String,
    override val accountType: String,
    override val currencyCode: String
) : NewBankAccount {
    override fun onFreeze() {
        TODO("Not yet implemented")
    }

    override fun onTransfer() {
        TODO("Not yet implemented")
    }

    override fun getTransactionList(): List<Transaction> {
        return transactionList
    }

    override fun getAccountTransactionHistory(receiverAccountNo: String): List<Transaction> {
        return transactionList.filter { it.receiverAccountNo == receiverAccountNo }
    }

    override fun filterTransaction(
        status: TransactionStatus,
        onResult: (list: List<Transaction>) -> Unit
    ) {
        val transactions = transactionList.filter { transaction -> transaction.status == status }
        onResult(transactions)
    }
}

fun main() {
    val saving = SavingAccount(
        accountName = "",
        accountNo = "",
        accountType = "",
        currencyCode = ""
    )
    val transactionList = saving.getTransactionList()
//    println(transactionList)
    saving.filterTransaction(status = TransactionStatus.FAILED) { list ->
//        println(list)
    }

    val transactionHistory = saving.getAccountTransactionHistory(receiverAccountNo = "009876543210")
    println(transactionHistory)
}

/**
 * Homework February 15, 2026
 * - Create any abstraction related to Transaction
 * - Create a rule using abstract class or interface about DepositAccount
 * - Subclass that implement from DepositAccount
 * - Define your data locally
 * - Instant subclass and testing the process
 * - Screenshot your code and the result send into the group of our class.
 */