package concurrency

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        coroutineScope {
            launch {
                delay(5000)
                println("Task 1")
            }

            launch {
                delay(1000)
                println("Task 2")
            }

            launch {
                delay(1000)
                println("Task 3")
            }

            launch {
                delay(5000)
                println("Task 4")
            }
        }
    }
}