package com.atustudentsafternoon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openNewPage()
        changeImage()
        //displayStudentName()
    }

    private fun changeImage(){
        val imageView: ImageView = findViewById(R.id.student_img)
        val button: Button = findViewById(R.id.display_btn)

        button.setOnClickListener {
            imageView.setImageResource(R.drawable.image_two)
        }
    }

    private fun openNewPage() {

        editText = findViewById(R.id.student_name_ed)
        val button: Button = findViewById(R.id.display_btn)

        button.setOnClickListener {
            val textFromEditText = editText.text.toString()

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("student_name", textFromEditText)
            startActivity(intent)
        }
    }

    private fun displayStudentName() {
        val textView: TextView = findViewById(R.id.student_name_tv)
        val button: Button = findViewById(R.id.display_btn)

        button.setOnClickListener {
            val textFromEditText = editText.text
            textView.text = textFromEditText
        }
    }
}