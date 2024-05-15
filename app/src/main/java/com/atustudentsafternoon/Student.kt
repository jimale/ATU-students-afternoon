package com.atustudentsafternoon

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val email: String,
    val age: Int
)
