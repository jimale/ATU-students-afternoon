package com.atustudentsafternoon

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentDetails()
    }

    private fun studentDetails() {

        val studentId = intent.getIntExtra("student_name", 0)

        Thread {

            val database = Room.databaseBuilder(
                applicationContext,
                MyDatabase::class.java, "my_db"
            )
                .fallbackToDestructiveMigration()
                .build()

            val studentDetails = database.studentDao().getStudentById(studentId)

            runOnUiThread {
                val studentName: TextView = findViewById(R.id.student_name_tv)
                val studentEmail: TextView = findViewById(R.id.student_email_tv)
                val studentPhone: TextView = findViewById(R.id.student_phone_tv)
                val studentAge: TextView = findViewById(R.id.student_age_tv)

                studentName.text = studentDetails.name
                studentEmail.text = studentDetails.email
                studentPhone.text = studentDetails.phoneNumber.toString()
                studentAge.text = studentDetails.age.toString()
            }

        }.start()
    }
}