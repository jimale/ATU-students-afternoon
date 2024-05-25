package com.atustudentsafternoon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Query("SELECT * from student")
    fun getStudents(): List<Student>

    @Query("SELECT * FROM student where id =:studentId")
    fun getStudentById(studentId: Int): Student
    @Insert
    fun saveStudent(student: Student)
}