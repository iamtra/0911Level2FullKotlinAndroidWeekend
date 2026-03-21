package controlFlow


data class StudentModel(
    val id: String,
    val name: String
)

fun main() {
    val list = listOf<String>("Apple", "Samsung", "Google Pixel")
    val studentList = listOf(
        StudentModel(id = "1706160001", name = "Student 1"),
        StudentModel(id = "1706160002", name = "Student 2"),
        StudentModel(id = "1706160003", name = "Student 3"),
        StudentModel(id = "1706160004", name = "Student 4"),
        StudentModel(id = "1706160005", name = "Student 5"),
        StudentModel(id = "1706160006", name = "Student 6"),
        StudentModel(id = "1706160007", name = "Student 7"),
        StudentModel(id = "1706160008", name = "Student 8"),
        StudentModel(id = "1706160009", name = "Student 9"),
        StudentModel(id = "1706160010", name = "Student 10")
    )

    val studentId = "1706160002"
    val student = getStudentById(id = studentId, studentList)
    val students = getStudentWithoutThisId(studentId, studentList)
    println("====> ${students.size}")
    println(students)

}

fun getStudentById(id: String, students: List<StudentModel>): StudentModel? {
    var count = 0
    for (item in students) {
        count++
        if (item.id == id) {
            return item
        }
    }
    return null
}

fun getStudentWithoutThisId(ignoreId: String, students: List<StudentModel>): List<StudentModel> {
    val newStudent = mutableListOf<StudentModel>()
    for (item in students) {
        if (item.id == ignoreId) {
            continue
        }
        newStudent.add(item)
    }
    return newStudent.toList()
}


/**
 * Homework (Related to Financial industry + Loop + Jum Expression)
 * 1. Create data class for TransactionModel
 * 2. Use Ai to create an array of transaction that contain around 100 to 200 record
 * 3. Find the first Bakong Transaction Type using for loop and terminate loop immediately
 * 4. Using for loop to filter out all Bakong Transfer Type using Continue
 * 5. Find any specific transaction id and return that object to the function using return
 * 6. Apply concept above to with OOP Concept
 */



