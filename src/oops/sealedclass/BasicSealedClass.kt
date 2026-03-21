package oops.sealedclass


data class UserModel(
    val id: Int,
    val username: String
)

/**
 * this the data in database
 */
val userList = listOf(
    UserModel(id = 1, username = "vanlila"),
    UserModel(id = 2, username = "machalate"),
    UserModel(id = 3, username = "iceCapuchino"),
    UserModel(id = 4, username = "jhonedoe"),
    UserModel(id = 5, username = "toyota"),
)

sealed class NetworkState<out T> {
    data class Success<out T>(val data: T) : NetworkState<T>()
    data class Error(val code: String, val message: String) : NetworkState<Nothing>()
    object Loading : NetworkState<Nothing>()
}

fun main() {
    val id = 4
    queryUserById(id = id) { state ->
        when (state) {
            is NetworkState.Error -> {
                println("${state.code} ${state.message}")
            }

            is NetworkState.Loading -> {
                println("Loading......")
            }

            is NetworkState.Success<UserModel> -> {
                println(state.data)
            }
        }
    }
}

fun requestApi(state: NetworkState<String>) {
    when (state) {
        is NetworkState.Loading -> {
            println("Api is requesting")
        }

        is NetworkState.Success -> {
            println(state.data)
        }

        is NetworkState.Error -> {
            println(state.code)
            println(state.message)
        }
    }
}

/**
 * 1. Function Like a back response Api
 *  - Error Case
 *  - Success Case
 *  - Loading
 * 2. Front end contain network state with sealed class
 *  - Error Case
 *  - Success Case
 *  - Loading
 *
 */

/**
 * Backend API
 */
fun queryUserById(id: Int, onResponse: (state: NetworkState<UserModel>) -> Unit) {
    onResponse(NetworkState.Loading)

    if (id <= 0) {
        onResponse(NetworkState.Error("001", "User id cannot be less than zero"))
        return
    }

    var isFound = false
    for (user in userList) {
        if (user.id == id) {
            onResponse(NetworkState.Success(data = user))
            isFound = true
            break
        }
    }

    if (!isFound) {
        onResponse(NetworkState.Error("002", "User $id is not found."))
    }
}









