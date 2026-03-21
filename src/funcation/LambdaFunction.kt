package funcation

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Locale

/**
 * Class nane uses Pascal Case
 *  - property uses UPPER_SNAKE_CASE
 */
enum class BarCode(val code: String, val country: String) {
    CAMBODIA(code = "38383847474", "Cambodia"),
    AUSTRALIA(code = "49585858585", "Australia")
}

object TimeZone {
    const val CAMBODIA = "Asia/Phnom_Penh"
}

fun main() {
    val barCode: String = BarCode.CAMBODIA.code

//    checkBarCode(barCode = barCode) { isSuccess, message ->
//        if (isSuccess) {
//            println(message)
//            return@checkBarCode
//        }
//        println(message)
//    }
    val filterAges = 18

    studentFilterByAges(list = students, filterAges) {
        println(it.size)
    }

}

fun checkBarCode(barCode: String, onResult: (isSuccess: Boolean, message: String) -> Unit) {
    when (barCode) {
        BarCode.CAMBODIA.code -> {
            onResult(true, BarCode.CAMBODIA.country)
        }

        BarCode.AUSTRALIA.code -> {
            onResult(true, BarCode.AUSTRALIA.country)
        }

        else -> {
            onResult(false, "Invalid bar code")
        }
    }
}


data class Student(
    val id: String,
    val firstName: String,
    val lastName: String,
    val dob: String // yyyyMMdd
)

fun studentFilterByAges(list: List<Student>, ages: Int, result: (list: List<Student>) -> Unit) {
    val filterList = list.filter { student ->
        val studentAges = calculateAges(student.dob)
        studentAges <= ages
    }

    result(filterList)
}

fun convertDateStringToDate(date: String): Date {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val localDate = LocalDate.parse(date, formatter)

    return Date.from(
        localDate
            .atStartOfDay(ZoneId.systemDefault())
            .toInstant()
    )
}

fun convertIsoToJavaDateFormat(iso: String): Date {
    val localDateTime = LocalDateTime.parse(iso)

    val zonedDateTime = localDateTime.atZone(
        ZoneId.of("Asia/Phnom_Penh") // GMT+07:00
    )

    return Date.from(zonedDateTime.toInstant())
}

fun calculateAges(dateOfBirth: String): Long {
    val iSODateString = LocalDateTime.now()
    val dob = convertDateStringToDate(dateOfBirth).toInstant().atZone(ZoneId.of(TimeZone.CAMBODIA))
    val currentDate =
        convertIsoToJavaDateFormat(iSODateString.toString()).toInstant().atZone(ZoneId.of(TimeZone.CAMBODIA))
    val ages = ChronoUnit.YEARS.between(dob, currentDate)
    return ages
}

/**
 * 12 Mins
 * Check stock of smartphone
 *
 */