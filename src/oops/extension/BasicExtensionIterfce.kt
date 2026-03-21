package oops.extension

interface StudentInterface {
    fun study()
    fun learn()
}

fun StudentInterface.onExam(): Boolean {
    return false
}

class Student : StudentInterface {
    override fun study() {
        TODO("Not yet implemented")
    }

    override fun learn() {
        TODO("Not yet implemented")
    }
}

fun main() {
    val student = Student()
    val result = student.onExam()

    println(result)
}

