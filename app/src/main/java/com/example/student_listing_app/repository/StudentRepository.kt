package com.example.student_listing_app.repository

import androidx.lifecycle.LiveData
import com.example.student_listing_app.data.StudentDao
import com.example.student_listing_app.model.Student

class StudentRepository(private val studentDao: StudentDao){

    val getAllData: LiveData<List<Student>> = studentDao.getAllData()

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }
}