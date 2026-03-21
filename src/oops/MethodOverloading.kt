package oops

open class Calculate1 {
    open fun plus(x: Int, y: Int): Int {
        return x + y
    }

    fun plus(x: Float, y: Float): Float {
        return x + y
    }

    fun plus(x: Double, y: Double): Double {
        return x + y
    }

    fun plus(x: UInt, y: UInt): UInt {
        return x + y
    }
}

fun main() {
    val calculate = Calculate1()

    val plusInt = calculate.plus(1, 1)
    val plusFloat = calculate.plus(1.0F, 1F)

    println("Plus is plusInt $plusInt")
    println("Plus is plusFloat $plusFloat")

}