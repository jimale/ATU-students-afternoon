package com.atustudentsafternoon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayStudentName()
    }

    private fun displayStudentName(){
        val textView : TextView = findViewById(R.id.student_name_tv)
        val editText : EditText = findViewById(R.id.student_name_ed)
        val button : Button = findViewById(R.id.display_btn)

        button.setOnClickListener {
            val textFromEditText = editText.text
            textView.text = textFromEditText
        }
    }
}