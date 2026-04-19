package concurrency

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Start")

    launch {
        delay(5000)
        println("Async Task Done")
    }

    println("End")
}