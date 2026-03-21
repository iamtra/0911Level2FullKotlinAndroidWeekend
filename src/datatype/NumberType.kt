package datatype


data class VisaCard(
    val cardID: String,
    val availableBalance: Double
)

typealias Name = String
typealias CardID = String
typealias VisaCardList = List<VisaCard>
typealias Failure = (String) -> Unit
typealias Success = (Double) -> Unit

fun main() {
    // Integer number
    val negativeByte: Byte = -128
    val positiveByte: Byte = 127

    val negativeShort: Short = -20202
    val positiveShort: Short = 4040

    val negativeInt: Int = -103030303
    val positiveInt: Int = 458474737

    val negativeLong: Long = -93939392392922
    val positiveLong: Long = 93939392392922

    // Floating-point number
    val negativeFloat: Float = -1000f
    val positiveFloating: Float = 4.9494948E7F

    val negativeDouble: Double = -48848448834.0
    val positiveDouble: Double = 3030303030444444444444444444444433333333333333333333333333333333333.0

    // Unsigned Integer Type
    val totalAmount: UInt = 1000U
    val size: UByte = 200u
    val storage: UShort = 1024U

    // Boolean
    var isPaid: Boolean = false
    isPaid = true


    // Char
    val letterA: Char = 'A'
    val symbolAdd: Char = '@'

    val text: String = "I love You      "

    // Immutable Array
    val students: Array<String> = arrayOf("Chumnith", "Ropon", "Tha Rith", "Salach", "Pichsovann", "Damrong", "Vitha")
    val studentList: List<String> = listOf("Chumnith", "Ropon", "Tha Rith", "Salach", "Pichsovann", "Damrong", "Vitha")

    // Mutable
    val visCardList: MutableList<VisaCard> = mutableListOf(
        VisaCard(
            cardID = "0000001",
            availableBalance = 1000000.0
        )
    )


    visCardList.add(VisaCard(cardID = "100002", 303.0))

    // Type aliases
    val username: Name = "vnlia"

    getCardBalance(
        id = "100002",
        list = visCardList,
        onNotFound = { errorMessage ->
            println(errorMessage)
        }
    ) { balance ->
        println("Balance is $balance")
    }
}

fun getCardBalance(id: CardID, list: VisaCardList, onNotFound: Failure, onSuccess: Success) {
    val result = list.find { it.cardID == id }

    if (result == null) {
        onNotFound("Card Id $id is not found")
    } else {
        onSuccess(result.availableBalance)
    }
}


