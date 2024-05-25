package com.atustudentsafternoon

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 4)
abstract class MyDatabase : RoomDatabase() {
   abstract fun studentDao(): StudentDAO
}