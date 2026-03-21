package utils

fun String.maskAccountNumber(visibleDigits: Int = 4): String {
    if (length <= visibleDigits) return this
    val maskedPart = "*".repeat(length - visibleDigits)
    val visiblePart = takeLast(visibleDigits)
    return maskedPart + visiblePart
}

fun String.formatCardNumber(): String {
    return chunked(4).joinToString(" ")
}


fun String.isValidAccountNumber(): Boolean {
    return this.matches(Regex("\\d{10,18}"))
}

fun String.toCustomerName(): String {
    return split(" ")
        .joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }
}

fun String.formatTransactionId(): String {
    val clean = uppercase()
    return if (clean.startsWith("TRX")) {
        "TRX-${clean.removePrefix("TRX")}"
    } else clean
}

fun String?.isNullOrBankEmpty(): Boolean {
    return this == null || this.trim().isEmpty()
}