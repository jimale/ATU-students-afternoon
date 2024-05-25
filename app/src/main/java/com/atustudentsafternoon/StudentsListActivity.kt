package com.atustudentsafternoon

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class StudentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        displayStudent()
    }

    private fun displayStudent() {
        Thread {

            val database = Room.databaseBuilder(
                applicationContext,
                MyDatabase::class.java, "my_db"
            )
                .fallbackToDestructiveMigration()
                .build()


            //Get the students from the database
            val studentsList = database.studentDao().getStudents()

            //Get back to MAIN UI thread to display student info
            runOnUiThread {
                val adapter = StudentAdapter(studentsList)
                val recyclerView: RecyclerView = findViewById(R.id.students_recyclerView)

                recyclerView.adapter = adapter
            }

        }.start()
    }

}