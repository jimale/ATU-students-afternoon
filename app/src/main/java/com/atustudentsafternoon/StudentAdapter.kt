package com.atustudentsafternoon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)

        return StudentViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.display(studentList[position])
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return studentList.size
    }

    // Holds the views for adding it to image and text
    class StudentViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val studentName: TextView = itemView.findViewById(R.id.student_name_tv)

        fun display(student: Student) {
            studentName.text = student.name
        }
    }
}