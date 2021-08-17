package com.example.student_listing_app.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.student_listing_app.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    @Update
    suspend fun updateStudent(student:Student)

    @Delete
    suspend fun deleteStudent(student:Student)

    @Query("Delete from student_table")
    suspend fun deleteAllStudents()

    @Query("Select * from student_table order by id ASC")
    fun getAllData(): LiveData<List<Student>>
}