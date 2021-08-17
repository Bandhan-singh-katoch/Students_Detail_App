package com.example.student_listing_app.repository

import androidx.lifecycle.LiveData
import com.example.student_listing_app.data.StudentDao
import com.example.student_listing_app.model.Student

class StudentRepository(private val studentDao: StudentDao){

    val getAllData: LiveData<List<Student>> = studentDao.getAllData()

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }

    suspend fun updateStudent(student: Student){
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }

    suspend fun deleteAllStudent(){
        studentDao.deleteAllStudents()
    }
}