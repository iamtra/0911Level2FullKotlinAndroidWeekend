package concurrency

fun main() {
    println("Start")

    Thread.sleep(2000) // sleep for 2 seconds (Block thread)

    println("End after 2 seconds")
}