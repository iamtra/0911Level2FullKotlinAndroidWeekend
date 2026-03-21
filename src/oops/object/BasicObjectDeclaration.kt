package oops.`object`


/**
 * To create an object in Kotlin programming language, we use object keyword
 * it calls singleTon Object
 */
object AccountTpe {
    val saving = "Saving"
    const val DEPOSIT = "deposit"
    var goldSaving = "goldSaving"
}

class BankAccountType {

    companion object {
        private var instance: BankAccountType? = null

        fun getInstance(): BankAccountType {
            if (instance == null) {
                instance = BankAccountType()
            }
            return instance!!
        }
    }

    val saving = "Saving"
}

enum class Error(val errorCode: String, val errorMessage: String) {
    FILED_CANNOT_BE_EMPTY(errorCode = "ERR_001", errorMessage = "Filed cannot be empty."),
    NOT_FOUND(errorCode = "ERR_002", errorMessage = "Not found.")
}

data class UserModel(
    val userId: String,
    val userName: String,
    val email: String,
    val phoneNumber: String,
    val isActive: Boolean
)

val userList = listOf(
    UserModel(
        userId = "U001",
        userName = "John Smith",
        email = "john.smith@gmail.com",
        phoneNumber = "012345678",
        isActive = true
    ),
    UserModel(
        userId = "U002",
        userName = "David Lee",
        email = "david.lee@gmail.com",
        phoneNumber = "098765432",
        isActive = true
    ),
    UserModel(
        userId = "U003",
        userName = "Anna Brown",
        email = "anna.brown@gmail.com",
        phoneNumber = "011223344",
        isActive = false
    ),
    UserModel(
        userId = "U004",
        userName = "Michael Chen",
        email = "michael.chen@gmail.com",
        phoneNumber = "066778899",
        isActive = true
    ),
    UserModel(
        userId = "U005",
        userName = "Sophia Kim",
        email = "sophia.kim@gmail.com",
        phoneNumber = "077889900",
        isActive = true
    )
)

/**
 * Anonymous objects
 * 1. Create contract (abstract class + abstract member or interface)
 * 2. Create a function that contain 2 params that has a listener
 * 3. Implement lister with Anonymous objects
 */
interface NetworkResult<T> {
    fun onSuccess(data: T)
    fun onFailure(errorCode: String, errorMessage: String)
}

fun getData(userId: String, onSuccess: () -> Unit, onFailure: () -> Unit) {

}

fun getUserDetail(userId: String, listener: NetworkResult<UserModel>) {
    if (userId.isEmpty()) {
        listener.onFailure(
            errorCode = Error.FILED_CANNOT_BE_EMPTY.errorCode,
            errorMessage = Error.FILED_CANNOT_BE_EMPTY.errorMessage
        )
        return
    }

    for (user in userList) {
        if (userId == user.userId) {
            listener.onSuccess(data = user)
            return
        }
    }

    listener.onFailure(
        errorCode = Error.NOT_FOUND.errorCode,
        errorMessage = Error.NOT_FOUND.errorMessage
    )

}


fun main() {
//    val saving = AccountTpe.saving
//
//    AccountTpe.goldSaving = "GoldNotSaving"
//    AccountTpe.goldSaving = "fjdtfjhhgfdhdfdf"
//
//    println(AccountTpe.goldSaving)
//
//
//    /**
//     * Create an instant
//     */
//    val bankAccountType = BankAccountType.getInstance()
//    val bankAccountType2 = BankAccountType()
//
//    println(bankAccountType2.saving)
//    println(bankAccountType.saving)

    val userId: String = "U002"

    getUserDetail(userId = userId, listener = object : NetworkResult<UserModel> {
        override fun onSuccess(data: UserModel) {
            println(data)
        }

        override fun onFailure(errorCode: String, errorMessage: String) {
            val error = """
                Error code is:       $errorCode
                Error message is:    $errorMessage
            """.trimIndent()
            println(error)
        }
    })
}


/**
 * Homework
 * 1. Create singleTon object related to Laptop
 * 2. Anonymous objects
 *      - Create contract (abstract class + abstract member or interface)
 *      - Create a function that contain 2 params that has a listener
 *      - Implement lister with Anonymous objects
 */
