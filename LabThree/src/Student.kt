class Student(name: String, age: Int, grades: List<Int>) {
    constructor(name: String) : this(name, 0, emptyList());

    private  var name: String = ""
        set(value) {
            field = value.trim().replaceFirstChar { it.uppercaseChar() }
        }

    private var age: Int = 0
        set(value) { if(value >= 0) field = value }

    private var grades: List<Int>

    val isAdult: Boolean
        get() = age >= 18

    val status: String by lazy {
        if(isAdult) "Adult" else "Minor"
    }

    init {
        this.name = name
        this.age = age
        this.grades = grades
        println("Student created")
    }

    fun getAverage() : Double {
        return grades.average()
    }

    fun processGrades(operation: ((Int) -> Int)) {
        this.grades = this.grades.map(operation)
    }

    fun updateGrades(newGrades: List<Int>) {
        this.grades = newGrades
    }

    operator fun plus(student: Student) : List<Int> {
        return this.grades + student.grades
    }

    operator fun times(multiplier: Int): Student {
        val multipliedGrades = this.grades.map { it * multiplier }
        this.grades = multipliedGrades
        return this
    }

    override operator fun equals(other: Any?): Boolean {
        if (other !is Student) return false
        return this.name == other.name && this.getAverage() == other.getAverage()
    }

}