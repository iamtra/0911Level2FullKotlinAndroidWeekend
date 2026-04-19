package concurrency

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val process = async {
            delay(5000)
            "Process is successful."
        }

        println("Waiting...")
        val result = process.await()
        println(result)
    }
}