package concurrency

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val result = requestData()
        println(result)
    }
}

/**
 * Example 1 of coroutine
 */
fun runBlock() {
    runBlocking {
        launch {
            delay(1000) // wait 1 second (non-blocking)
            println("Hello from coroutine!")
        }

        println("Hello from main")
    }
}

/**
 * Example 2 launch
 */
fun launch() {
    runBlocking {
        //launch → no result
        launch {
            delay(100)
            println("World!")
        }
    }
}

fun async() {
    runBlocking {
        val result = async {
            delay(1000)
            42
        }

        println("Result: ${result.await()}")
    }
}

suspend fun requestData(): String {
    delay(1000)
    return "OK"
}
