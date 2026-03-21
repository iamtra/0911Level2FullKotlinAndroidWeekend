package oops.data

data class TransactionModel(
    val transactionId: String,
    val transactionAmount: Double,
    val currency: String,

    // Sender
    val senderName: String,
    val senderAccountNo: String,

    // Receiver
    val receiverName: String,
    val receiverAccountNo: String,

    // Meta
    val transactionType: String, // Bakong, fund transfer, International fund  transfer... 
    val transactionStatus: String, // Pen         vvvvccccfffffff         ding, Failed, Success
    val transactionDate: String,        // e.g. 2026-02-21T10:30:00
    val referenceNo: String,

    // Optional
    val remark: String? = null,
    val feeAmount: Double = 0.0
)


fun main() {
    val transactionObject = TransactionModel(
        transactionId = "TXN202602210001",
        transactionAmount = 150.75,
        currency = "USD",

        senderName = "John Doe",
        senderAccountNo = "001234567890",

        receiverName = "Jane Smith",
        receiverAccountNo = "009876543210",

        transactionType = "Bakong",
        transactionStatus = "Success",

        transactionDate = "2026-02-21T10:45:30",
        referenceNo = "REF987654321",

        remark = "Monthly rent payment",
        feeAmount = 1.50
    )

    val list: List<TransactionModel> = listOf(
        TransactionModel(
            transactionId = "TXN202602210001",
            transactionAmount = 120.50,
            currency = "USD",
            senderName = "Buon Pheaktra",
            senderAccountNo = "ACC100001",
            receiverName = "Amazon",
            receiverAccountNo = "MER0001",
            transactionType = "",
            transactionStatus = "",
            transactionDate = "2026-02-21T09:10:00",
            referenceNo = "REF-AMZ-001",
            remark = "Online shopping",
            feeAmount = 1.25
        ),
        TransactionModel(
            transactionId = "TXN202602210002",
            transactionAmount = 250.00,
            currency = "KHR",
            senderName = "Buon Pheaktra",
            senderAccountNo = "ACC100001",
            receiverName = "Electricity Authority",
            receiverAccountNo = "BILL1002",
            transactionType = "",
            transactionStatus = "",
            transactionDate = "2026-02-20T18:45:00",
            referenceNo = "REF-ELEC-002",
            remark = "Electric bill",
            feeAmount = 0.0
        ),
        TransactionModel(
            transactionId = "TXN202602210003",
            transactionAmount = 75.00,
            currency = "USD",
            senderName = "Buon Pheaktra",
            senderAccountNo = "ACC100001",
            receiverName = "Jane Smith",
            receiverAccountNo = "ACC200002",
            transactionType = "",
            transactionStatus = "",
            transactionDate = "2026-02-21T11:30:00",
            referenceNo = "REF-TRF-003",
            remark = "Lunch refund",
            feeAmount = 0.50
        ),
        TransactionModel(
            transactionId = "TXN202602210004",
            transactionAmount = 500.00,
            currency = "USD",
            senderName = "Company Payroll",
            senderAccountNo = "ACC-PAYROLL",
            receiverName = "Buon Pheaktra",
            receiverAccountNo = "ACC100001",
            transactionType = "",
            transactionStatus = "",
            transactionDate = "2026-02-19T08:00:00",
            referenceNo = "REF-SALARY-004",
            remark = "Monthly salary",
            feeAmount = 0.0
        ),
        TransactionModel(
            transactionId = "TXN202602210005",
            transactionAmount = 100.00,
            currency = "USD",
            senderName = "Buon Pheaktra",
            senderAccountNo = "ACC100001",
            receiverName = "ABA ATM",
            receiverAccountNo = "ATM-ABA-01",
            transactionType = "",
            transactionStatus = "",
            transactionDate = "2026-02-18T14:20:00",
            referenceNo = "REF-ATM-005",
            remark = "Insufficient balance",
            feeAmount = 2.00
        )
    )

    println(transactionObject)
}
