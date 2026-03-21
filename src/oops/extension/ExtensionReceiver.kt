package oops.extension

class Loan {
    var loanId: String = ""
}


fun Loan.updateLoanId(id: String) {
    this.loanId = id
}