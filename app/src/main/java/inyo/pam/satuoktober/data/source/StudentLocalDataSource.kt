package inyo.pam.satuoktober.data.source

import inyo.pam.satuoktober.data.model.Student

class StudentLocalDataSource {
    private val students = listOf(
        Student(2026, "Dewa Nyoman", "Teknik Informatika", 2026),
        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
        Student(2028, "Citra Lestari", "Teknik Informatika", 2026),
        Student(2029, "Rahmi Arsy", "Teknik Informatika", 2026),
        Student(2030, "Laurensia Natania", "Teknik Informatika", 2026)
    )

    fun getStudentById(id: Int): Student? =
        students.find { it.id == id }

    fun getStudents(): List<Student> = students
}
