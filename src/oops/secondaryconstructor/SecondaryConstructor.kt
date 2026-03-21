package oops.secondaryconstructor

class Person(val fullName: String, val sex: String) {
    var ages = 0

    constructor(
        firstName: String,
        lastName: String,
        sex: String
    ) : this(fullName = "$firstName $lastName", sex = sex) {
        if (firstName.isEmpty()) {
            println("First Name cannot be empty.")
        } else if (lastName.isEmpty()) {
            println("Last name cannot be empty.")
        }
    }

    constructor(
        firstName: String,
        lastName: String,
        sex: String,
        ages: Int
    ) : this(fullName = "$firstName $lastName", sex = sex) {
        if (ages < 0) {
            println("Ages cannot be less than zero.")
        }
    }


    fun displayInfo() {
        println("Full name is : $fullName")
        println("Sex is : $sex")
    }

}


fun main() {
    val firstName: String = "Pheaktra"
    val lastName: String = "Developer"

    val fullName: String = "$firstName $lastName"

    val person1 = Person(fullName = fullName, sex = "Male")

//    person1.displayInfo()
//    getUUserInfo()
    getPerson3()

}

fun getUUserInfo() {
    val firstName: String = "Pheaktra"
    val lastName: String = "Developer"
    val sex = "Female"

    val person2 = Person(firstName = firstName, lastName = lastName, sex = sex)
    person2.displayInfo()
}


fun getPerson3() {
    val firstName: String = "Pheaktra"
    val lastName: String = "Developer"
    val sex = "Female"
    val ages = -1

    val person3 = Person(firstName = firstName, lastName = lastName, sex = sex, ages = ages)
}