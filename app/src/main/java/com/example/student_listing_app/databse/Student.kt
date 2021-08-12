package com.example.student_listing_app.databse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name : String,
    val course : String,
    val phoneNumber : Long
)