package oops

open class Loan {
    open fun getLoanName() {
        println("Get loan name")
    }
}

class CarLoan : Loan() {
    override fun getLoanName() {
        super.getLoanName()
    }

    fun getLoadAmount() {

    }
}