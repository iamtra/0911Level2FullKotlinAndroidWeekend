package oops.data

data class Transaction(
    val transactionId: String,
    val senderName: String,
    val senderAccountNo: String,
    val receiverName: String,
    val receiverAccountNo: String,
    val amount: Double,
    val currency: String,
    val transactionDate: String, // e.g. 20250215 or 2025-02-15T10:30:00
    val status: TransactionStatus
)

enum class TransactionStatus {
    PENDING,
    SUCCESS,
    FAILED
}

val transactionList = listOf(
    Transaction(
        transactionId = "TXN1001",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Sok Dara",
        receiverAccountNo = "009876543210",
        amount = 120.50,
        currency = "USD",
        transactionDate = "2025-02-01T09:15:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1002",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Chanthy Sok",
        receiverAccountNo = "004567891234",
        amount = 250.00,
        currency = "USD",
        transactionDate = "2025-02-02T11:30:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1003",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Vannak Lim",
        receiverAccountNo = "007654321098",
        amount = 75.25,
        currency = "USD",
        transactionDate = "2025-02-03T14:45:00",
        status = TransactionStatus.PENDING
    ),
    Transaction(
        transactionId = "TXN1004",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Nita Chhem",
        receiverAccountNo = "006789012345",
        amount = 500.00,
        currency = "USD",
        transactionDate = "2025-02-04T16:10:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1005",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Rithy Kim",
        receiverAccountNo = "003456789012",
        amount = 60.00,
        currency = "USD",
        transactionDate = "2025-02-05T10:00:00",
        status = TransactionStatus.FAILED
    ),
    Transaction(
        transactionId = "TXN1006",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Sopheak Mean",
        receiverAccountNo = "008901234567",
        amount = 980.75,
        currency = "USD",
        transactionDate = "2025-02-06T13:20:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1007",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Kanha Touch",
        receiverAccountNo = "002345678901",
        amount = 35.99,
        currency = "USD",
        transactionDate = "2025-02-07T18:05:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1008",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Piseth Nou",
        receiverAccountNo = "001122334455",
        amount = 410.00,
        currency = "USD",
        transactionDate = "2025-02-08T08:40:00",
        status = TransactionStatus.PENDING
    ),
    Transaction(
        transactionId = "TXN1009",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Sreypov Heng",
        receiverAccountNo = "005566778899",
        amount = 150.00,
        currency = "USD",
        transactionDate = "2025-02-09T12:55:00",
        status = TransactionStatus.SUCCESS
    ),
    Transaction(
        transactionId = "TXN1010",
        senderName = "Buon Pheaktra",
        senderAccountNo = "001234567890",
        receiverName = "Bora Chea",
        receiverAccountNo = "009988776655",
        amount = 720.30,
        currency = "USD",
        transactionDate = "2025-02-10T15:35:00",
        status = TransactionStatus.SUCCESS
    )
)
