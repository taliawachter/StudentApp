package com.example.studentapp

import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.StudentRowLayoutBinding
import com.example.studentapp.models.Student

class StudentRowViewHolder(
    private val binding: StudentRowLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null

    init {
        binding.checkbox.setOnClickListener { view ->
            (view?.tag as? Int)?.let { tag ->
                student?.isPresent = binding.checkbox.isChecked
            }
        }
    }

    fun bind(student: Student, position: Int){
        this.student = student
        binding.nameTextView.text = student.name
        binding.idTextView.text = student.id
        binding.checkbox.apply {
            isChecked = student.isPresent
            tag = position
        }
    }
}
