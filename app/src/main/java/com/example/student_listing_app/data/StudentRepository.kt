package com.example.student_listing_app.data

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao){

    val getAllData: LiveData<List<Student>> = studentDao.getAllData()

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }
}