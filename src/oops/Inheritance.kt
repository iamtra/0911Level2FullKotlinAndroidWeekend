package oops

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class BankAccount() {
    private var accountId: String = ""
    var accountName: String = ""
    private var accountNickname: String = ""
    protected var accountNo: String = ""
    protected var isFreeze: Boolean = false
    var createDate: String = ""
    var createTime: String = ""
    var availableBalance: Double = 0.0
    var currency: String = ""
    var isDefault: Boolean = false

    fun setDefault() {
        this.isDefault = true
    }

    fun updateAccountNickName(name: String) {
        accountNickname = name
    }

    fun updateAccountNo(accountNo: String) {
        this.accountNo = accountNo
    }
}

open class DepositAccount : BankAccount() {
    fun onTransfer() {
        println("Transfer")
    }

    fun updateAccountName(name: String) {
        this.accountName = name
    }

    fun onUnfreeze() {
        this.isFreeze = false
    }
}

class GoldSaving : DepositAccount() {
    var interestRate: Float = 0.0f
    private var _gold: String = ""

    var gold: String
        get() = _gold
        set(value) {
            _gold = value
        }

    fun updateNickName() {

    }

    fun onFreeze() {
        this.isFreeze = true
    }

    fun accountCheck() {

    }
}


fun main() {
    val account = BankAccount()
    val depositAccount = DepositAccount()
    depositAccount.updateAccountName("Pheaktra")
//    println("Account: ${account.accountName}")
//    println("Deposit: ${depositAccount.accountName}")


//    val dateTimeFormat = DateTimeFormat()
//    val date = dateTimeFormat.formatDate("20260101")
//    println(date)

    val goldSaving = GoldSaving()
    goldSaving.gold = "Buy a house"

    println(goldSaving.gold)



}

open class DateTimeFormat {
    private val yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd")
    private val yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    protected val displayFormat = DateTimeFormatter.ofPattern("dd MMM yyyy")

    fun formatDate(dateString: String): String {
        return when (dateString.length) {
            8 -> { // yyyyMMdd
                LocalDate.parse(dateString, yyyyMMdd)
                    .format(displayFormat)
            }

            14 -> { // yyyyMMddHHmmss
                LocalDateTime.parse(dateString, yyyyMMddHHmmss)
                    .format(displayFormat)
            }

            else -> dateString // fallback
        }
    }
}

class DateTimeFormatV2() {

}























