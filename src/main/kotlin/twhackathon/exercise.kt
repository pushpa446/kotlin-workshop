package twhackathon

import java.io.File

data class Employee(val name: String, val department: String, val salary: Int, val gender: Employee.Gender) {
    enum class Gender() { MALE, FEMALE, OTHER }
}

fun getEmployees(): List<Employee> {
    val lines = File("employees.txt").readLines()
    return lines.map { it.split(",") }
            .map { words ->
                Employee(
                        name = words[0],
                        department = words[3],
                        salary = words[2].toInt(),
                        gender = when (words[1]) {
                            "F" -> Employee.Gender.FEMALE
                            "M" -> Employee.Gender.MALE
                            "O" -> Employee.Gender.OTHER
                            else -> throw Exception("Unknown gender 🌈‍♂️")
                        })
            }
}
