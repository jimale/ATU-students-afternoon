package com.atustudentsafternoon

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        saveNameToSharedPreferences()
    }

    private fun saveNameToSharedPreferences() {
        val editText: EditText = findViewById(R.id.student_name_ed)
        val textView: TextView = findViewById(R.id.display_name_tv)
        val button: Button = findViewById(R.id.save_btn)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        button.setOnClickListener {
            //Saving the name to the sharedPreferences
            val textFromEditText = editText.text.toString()
            editor.putString("student_name", textFromEditText).apply()
        }

        //Get the name from the shared preferences
        textView.text = sharedPreferences.getString("student_name", "")

    }
}