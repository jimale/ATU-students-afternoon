package com.atustudentsafternoon

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        displayName()
    }

    private fun displayName(){
        val textView : TextView = findViewById(R.id.display_name_tv)
        val name = intent.getStringExtra("student_name")

        textView.text = "Student name is $name"
    }
}