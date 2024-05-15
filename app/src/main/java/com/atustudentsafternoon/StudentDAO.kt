package com.atustudentsafternoon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Query("SELECT * from student")
    fun getStudents(): List<Student>

    @Insert
    fun saveStudent(student: Student)
}