package com.atustudentsafternoon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class DatabaseActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_activity)

        val saveStudentButton: Button = findViewById(R.id.save_student_btn)
        val displaytudentButton: Button = findViewById(R.id.display_student_btn)
        saveStudentButton.setOnClickListener {
            Thread{
                saveStudent()
            }.start()
        }
        displaytudentButton.setOnClickListener {
            displayStudent()
        }
    }

    private fun saveStudent() {

        val database = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "my_db"
        ).build()

        val studentName: EditText = findViewById(R.id.student_name_edt)
        val studentEmail: EditText = findViewById(R.id.student_email_et)
        val studentAge: EditText = findViewById(R.id.student_age_et)

        //Student entity or student table
        val student = Student(
            id = 1,
            name = studentName.text.toString(),
            email = studentEmail.text.toString(),
            age = studentAge.text.toString().toInt()
        )

        //Save student info
        database.studentDao().saveStudent(student)

    }

    private fun displayStudent(){
        Thread{

            val database = Room.databaseBuilder(
                applicationContext,
                MyDatabase::class.java, "my_db"
            ).build()

            //Declare views
            val textView: TextView = findViewById(R.id.display_student_tv)

            //Get the students from the database
            val students = database.studentDao().getStudents()

            //Get back to MAIN UI thread to display student info
            runOnUiThread {
                //Display student
                textView.text = students.toString()
            }

        }.start()
    }
}