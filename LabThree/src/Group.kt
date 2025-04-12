class Group(vararg students: Student) {
    private val students = students

    operator fun get(index: Int): Student? {
        return if(index in students.indices) students[index] else null
    }

    fun getTopStudent(): Student? {
        return students.maxByOrNull { it.getAverage() }
    }
}