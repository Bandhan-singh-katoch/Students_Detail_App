package com.example.student_listing_app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun addStudent(student:Student)

    @Query("Select * from student_table order by id ASC")
    fun getAllData(): LiveData<List<Student>>
}