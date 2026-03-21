package funcation

import datatype.Failure
import kotlin.system.measureTimeMillis

fun main() {
    val inlineTime = measureTimeMillis {
        repeat(1_000_000) {
            testInline {
                repeat(10_000) {
                    // empty work
                }
            }
        }
    }

    val normalTime = measureTimeMillis {
        repeat(1_000_000) {
            testNormal {
                repeat(10_000) {
                    // empty work
                }
            }
        }
    }



    println("Inline function time : $inlineTime ms")
    println("Normal function time : $normalTime ms")
}

inline fun testInline(
    onSuccess: () -> Unit,
) {
    onSuccess()
}

fun testNormal(
    onSuccess: () -> Unit,
) {
    onSuccess()
}
