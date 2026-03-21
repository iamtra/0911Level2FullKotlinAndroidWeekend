package oops.extension

open class Person {
    var firstName: String = ""
    var lastName: String = ""

    /***
     * Extension as a member
     */
    fun String.formatAge() {
        println("Dispatch to string class ${this.length}")
        println("Dispatch to Person class ${this@Person.lastName.length}")
    }

    fun Loan.getLoanDetail(id: String) {

        println(id)
    }

    fun String.textCount(): Int {
        return this.length
    }

    fun String.setValue(value: String) {
        this@Person.lastName = value
    }


    fun concatName(): String {
        return "$firstName $lastName"
    }

    fun checkLength(value: String) {
        value.setValue(value)
        println(lastName)
    }

    fun getLoan(id: String) {
        val loan = Loan()
        loan.getLoanDetail(id)
    }
}


data class TransactionModel(
    val transactionId: String,
    val transactionType: String
)

val list = listOf(
    TransactionModel(
        transactionId = "TRX4949494",
        transactionType = "Own Bank Transfer"
    ),
    TransactionModel(
        transactionId = "TRX4949495",
        transactionType = "Interbank Transfer"
    ),
    TransactionModel(
        transactionId = "TRX4949496",
        transactionType = "Bill Payment"
    ),
    TransactionModel(
        transactionId = "TRX4949497",
        transactionType = "Mobile Top Up"
    ),
    TransactionModel(
        transactionId = "TRX4949498",
        transactionType = "QR Payment"
    ),
    TransactionModel(
        transactionId = "TRX4949499",
        transactionType = "International Transfer"
    )
)

class Transaction {
    var transactionList: List<TransactionModel> = emptyList()
    var transactionDetail: TransactionModel? = null
    fun getTransactionList() {
        transactionList = list
    }

    fun getTransactionDetail(id: String) {
        transactionDetail = list.find { it.transactionId == id }
    }
}

class Account {
    fun Transaction.filterTransaction(transactionType: String, onResult: (List<TransactionModel>) -> Unit) {
        this.getTransactionList()
        val result = this.transactionList.filter { it.transactionType == transactionType }
        onResult(result)
    }

    fun filterTransactionLst(transactionType: String, transaction: Transaction): List<TransactionModel> {
        var transactionList: List<TransactionModel> = emptyList()
        transaction.filterTransaction(transactionType) {
            transactionList = it
        }

        return transactionList
    }
}

class Sok : Person() {
    fun gettextLength(text: String) {
        println(this)
    }
}

fun main() {
    val transaction = Transaction()
    val instant = Account()
    val transactionFilter = instant.filterTransactionLst("QR Payment", transaction)
    println(transactionFilter)
}

/**
 * Research more about extension receiver and dispatcher
 */