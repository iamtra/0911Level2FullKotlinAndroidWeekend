package oops

class Student(val fullName: String) {

    constructor(firstName: String, lastName: String) : this(fullName = "$firstName $lastName") {
        println(fullName)
    }
}

fun main() {
    val student1 = Student(fullName = "Pheaktra Developer")
    val student2 = Student(firstName = "Pheaktra", lastName = "Developer")

    println("Full name of student 1 is: ${student1.fullName}")
    println("Full name of student 2 is: ${student2.fullName}")
}