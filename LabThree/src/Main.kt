import kotlinx.coroutines.*


fun main() = runBlocking {
    // async grades update
    val studentMykhailo = Student(name = "Mykhailo")

    val text by lazy { println("Lazy init") "Hello" }
    println("Start")
    println(text)
    println(text)

    val grades = coroutineScope {
        async { fetchGradesFromServer() }
    }.await()
    studentMykhailo.updateGrades(grades)

    // Creating students
    val studentOne = Student(name = "StudentOne")
    val studentTwo = Student(name = "StudentTwo")

    // Adding grades
    val gradesForStudentOne = listOf(89, 90, 95)
    val gradesForStudentTwo = listOf(60, 75, 89)

    studentOne.updateGrades(gradesForStudentOne)
    studentTwo.updateGrades(gradesForStudentTwo)

    // Перевантаження +
    val combinedStudent = studentOne + studentTwo
    println("Combined student: $combinedStudent")

    // Перевантаження *
    val boostedStudent = studentTwo * 2
    println("Boosted grades: $boostedStudent")

    // == порівняння
    println("student2 == anotherAndrii: ${ studentOne == studentTwo }")

    // lazy
    println("status: ${studentOne.status}")

    suspend fun fetchGradesFromServer(): List<Int> {
        delay(2000)
        return listOf(95, 87, 90, 100, 78)
    }
}