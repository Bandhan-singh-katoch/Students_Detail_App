package com.example.student_listing_app.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class],version = 1,exportSchema = false)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun studentDao() : StudentDao

    companion object{                            //everything in companion object is visible to other classes

        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context:Context): StudentDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}