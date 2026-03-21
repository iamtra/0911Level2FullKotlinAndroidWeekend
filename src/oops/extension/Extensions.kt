package oops.extension

open class Accessory {
    val subTotal = 1000
    val tax = 10
    open fun onSell() {
        println("Memeber")
    }

    companion object {

    }

    fun onGenerateInvoice(): String {
        return """
            ""${'"'}
            ================== INVOICE ==================
            Invoice No   : INV-2026-0001
            Date         : 2026-02-28
            Customer     : Member
            
            ------------------ ITEM --------------------
            Product Name : Phone Charger
            Category     : Accessory
            Unit Price   : 15.00 USD
            Quantity     : 2
            
            ------------------ TOTAL -------------------
            Subtotal     : $subTotal USD
            Tax (10%)    : $tax USD
            Grand Total  : 33.00 USD
            
            ------------------ PAYMENT -----------------
            Payment Mode : Cash
            Status       : PAID
            
            ===========================================
            Thank you for your purchase!
        ""${'"'}.trimIndent()
        """.trimIndent()
    }
}

fun Accessory.generateNewInvoice(): String {
    return """
            ""${'"'}
            ================== INVOICE ==================
            Invoice No   : INV-2026-0001
            Date         : 2026-02-28
            Customer     : Member
            
            ------------------ ITEM --------------------
            Product Name : Phone Charger
            Category     : Accessory
            Unit Price   : 15.00 USD
            Quantity     : 2
            
            ------------------ TOTAL -------------------
            Subtotal     : $subTotal USD
            Tax (10%)    : $tax USD
            Grand Total  : $total USD
            
            ------------------ PAYMENT -----------------
            Payment Mode : Cash
            Status       : PAID
            
            ===========================================
            Thank you for your purchase!
        ""${'"'}.trimIndent()
        """.trimIndent()
}

val Accessory.total: Int get() = subTotal + tax

class ComputerAccessory : Accessory() {
    override fun onSell() {
        super.onSell()
    }

    fun generateReport() {
        onGenerateInvoice()
    }
}

/**
 * Companion extension
 */
fun Accessory.Companion.logger(logInfo: String) {
    println(logInfo)
}

fun main() {
    val accessory = Accessory()
    val invoice = accessory.generateNewInvoice()
    Accessory.logger(invoice)

    val mic = Microphone()
    mic.onRecord()
    mic.stopRecord()


}

/**
 * Related visibility modifier in Kotlin contain
 * - Public allow to access everywhere
 * - private allow access only the file
 * - internal allow access only the same module
 */
class Microphone {
    internal fun onRecord() {

    }
}

fun Microphone.stopRecord() {
    println("Record is stopped.")
}
