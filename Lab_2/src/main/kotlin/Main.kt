package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    findMaxOfThreeNumbers()
    calculateFactorial()
    countSumOnEvenIndices()
    getStringLength(null)
    classManager()
}

// Conditional expressions
fun findMaxOfThreeNumbers() {
    println("Enter three numbers separated by commas (e.g. 12,5,33):")
    val input = readLine()

    val numbers = input
        ?.split(",")
        ?.mapNotNull { it.trim().toIntOrNull() }

    if (numbers == null || numbers.size != 3) {
        println("Invalid input. Please enter exactly three valid integers separated by commas.")
        return
    }

    val max = numbers.filterNotNull().maxOrNull()
    println("The maximum number is: $max")
}

// Loops

fun calculateFactorial() {
    println("Enter a non-negative integer to calculate its factorial:")

    val input = readLine()
    val number = input?.trim()?.toIntOrNull()

    if (number == null || number < 0) {
        println("Invalid input. Please enter a non-negative integer.")
        return
    }

    var result = 1L
    for (i in 1..number) {
        result *= i
    }

    println("Factorial of $number is: $result")
}

// Arrays

fun countSumOnEvenIndices() {
    println("Enter numbers separated by commas (e.g. 12,5,33):")
    val input = readLine()

    val numbers = input?.split(",")
        ?.mapNotNull { it.trim().toIntOrNull() }

    val sum = numbers
        ?.filterIndexed { index, _ -> index % 2 == 0 }
        ?.sum()

    println("Sum of numbers at even indices: ${sum ?: 0}")
}

// Null safety

fun getStringLength(input: String?): Int {
    return input?.length ?: 0
}

fun classManager() {
    val numClasses: Int

    while (true) {
        println("Введіть кількість класів (від 1 до 5):")
        val input = readLine()
        val potentialNum = input?.toIntOrNull()

        if (potentialNum != null && potentialNum in 1..5) {
            numClasses = potentialNum
            break
        } else {
            println("Неправильне значення! Будь ласка, введіть число від 1 до 5.")
        }
    }

    println("Прийнято: $numClasses клас(ів).")

    val grades = Array(numClasses) { mutableListOf<Int>() }

    for (i in 0 until numClasses) {
        println("Клас ${i + 1}: Введіть кількість учнів:")
        val studentCount = readLine()?.toIntOrNull()
        if (studentCount == null || studentCount <= 0) {
            println("Некоректна кількість учнів. Пропускаємо клас.")
            continue
        }

        for (j in 0 until studentCount) {
            print("Оцінка учня ${j + 1}: ")
            try {
                val grade = readLine()?.toInt()
                if (grade != null && grade in 1..12) {
                    grades[i].add(grade)
                } else {
                    println("Недопустима оцінка (потрібно від 1 до 12). Введення пропущено.")
                }
            } catch (e: NumberFormatException) {
                println("Недопустиме введення. Введення пропущено.")
            }
        }
    }

    var maxAverage = Double.MIN_VALUE
    var topClassIndex = -1

    println("\nРезультати аналізу:")
    for ((index, classGrades) in grades.withIndex()) {
        if (classGrades.isEmpty()) {
            println("Клас ${index + 1}: немає оцінок.")
            continue
        }

        val average = classGrades.average()
        val topStudents = classGrades.count { it >= 10 }
        val topPercent = if (classGrades.isNotEmpty()) topStudents * 100.0 / classGrades.size else 0.0

        println("Клас ${index + 1}: середній бал = %.2f, відмінників = %.1f%%"
            .format(average, topPercent))

        if (average > maxAverage) {
            maxAverage = average
            topClassIndex = index
        }
    }

    if (topClassIndex != -1) {
        println("\nКлас з найвищим середнім балом: ${topClassIndex + 1} (%.2f)"
            .format(maxAverage))
    } else {
        println("\nЖодного класу з оцінками не було введено.")
    }
}