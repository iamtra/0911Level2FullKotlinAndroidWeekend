package oops

abstract class Calculate {
    abstract fun plus(x: Int, y: Int): Int

    abstract fun plus(x: Float, y: Float) : Float

    abstract fun devive(x: Int, y: Int): Int
}

class ScoreCalculation : Calculate() {
    override fun plus(x: Int, y: Int): Int {
        return x + y
    }

    override fun plus(x: Float, y: Float): Float {
        return x+ y
    }

    override fun devive(x: Int, y: Int): Int {
        return x % y
    }

    fun minus() {

    }
}

fun main() {
    val scoreCalculation = ScoreCalculation()
    val result = scoreCalculation.plus(1F, 4F)
    println(result)
}
