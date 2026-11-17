package inyo.pam.satuoktober.data.repository

import inyo.pam.satuoktober.data.model.Student
import inyo.pam.satuoktober.data.source.StudentLocalDataSource

interface StudentRepository {
    fun getStudentById(id: Int): Student?
    fun getStudents(): List<Student>
}

class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource
) : StudentRepository {
    override fun getStudentById(id: Int): Student? =
        dataSource.getStudentById(id)

    override fun getStudents(): List<Student> =
        dataSource.getStudents()
}
