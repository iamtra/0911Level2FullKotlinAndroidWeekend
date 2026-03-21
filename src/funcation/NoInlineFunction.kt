package funcation

import kotlin.system.measureTimeMillis

inline fun testMultipleCallbackInline1(
    onSuccess: () -> Unit,
    noinline onFailure: () -> Unit
) {
    onSuccess()
}

fun testMultipleCallbackNormal2(
    onSuccess: () -> Unit,
    onFailure: () -> Unit
) {
    onSuccess()
}



fun main() {
    val loopCount = 1_000_000

    val inlineWithNoinlineTime = measureTimeMillis {
        repeat(loopCount) {
            testMultipleCallbackInline1(
                onSuccess = {
                    repeat(10_000) {
                        // simulate work
                    }
                },
                onFailure = {
                    repeat(10_000) {
                        // simulate work
                    }
                }
            )
        }
    }

    val normalFunctionTime = measureTimeMillis {
        repeat(loopCount) {
            testMultipleCallbackNormal2(
                onSuccess = {
                    repeat(10_000) {
                        // simulate work
                    }
                },
                onFailure = {
                    repeat(10_000) {
                        // simulate work
                    }
                }
            )
        }
    }

    println("Inline + noinline time : $inlineWithNoinlineTime ms")
    println("Normal function time  : $normalFunctionTime ms")
}