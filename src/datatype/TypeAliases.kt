package datatype

typealias Username = String
typealias FreeResult = (id: String, feeAmount: Double, feeType: String, feeByTransaction: Double) -> Unit
typealias OnResult<T> = (value: T) -> Unit
typealias CalculateFee<T> = (amount: Int, onResult: (T) -> Unit) -> Unit

typealias Failures = (code: String, message: String) -> Unit
typealias Successes<S> = (response: S) -> Unit
typealias ApiRequestResponse<T, S> = (body: T, onFailure: Failures, onSuccess: Successes<S>, response: S) -> Unit

data class RequestBody(
    val id: String,
    val refNo: Int
)

data class ApiResponse(
    val status: String,
    val message: String
)


fun main() {
    val mockData = ApiResponse(status = "200", message = "Success") // Data for response

    val mockArray = listOf<ApiResponse>(mockData)

    requestApi<String, ApiResponse>(
        body = "001",
        onFailure = { code, message ->
            println(code)
            println(message)
        },
        onSuccess = {
            println(it)
        },
        mockResponse = mockData
    )

    requestApi<Int, List<ApiResponse>>(
        body = 1000,
        onFailure = { code, message ->

        },
        onSuccess = {

        },
        mockResponse = mockArray
    )

    val body = RequestBody(
        id = "001",
        refNo = 10101
    )
}

// Unit
fun getFree(result: FreeResult) {
    result("0001", 1000.0, "Fee By Transaction", 10.0)
}

fun <T> calculateFree(value: CalculateFee<T>) {
    value(1000) {
        println(it)
    }
}

fun <T, S> requestApi(
    body: T,
    onFailure: Failures,
    onSuccess: Successes<S>,
    mockResponse: S
) {
    // Request to Api

    onFailure("404", "Cannot connect to the server.") // Error

    println("Body $body")

    onSuccess(mockResponse)
}