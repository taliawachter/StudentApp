package com.example.studentapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addStudentButton: Button = findViewById(R.id.add_student_save_student_button)
        val cancelButton: Button = findViewById(R.id.add_student_cancel_button)

        val studentNameEditText: EditText = findViewById(R.id.add_student_name_edit_text)
        val studentIdEditText: EditText = findViewById(R.id.add_student_id_edit_text)

        val saveStudentTextView: TextView = findViewById(R.id.add_student_save_status_text_view)

        cancelButton.setOnClickListener {
            finish()
        }

        addStudentButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()

            saveStudentTextView.text = "Student Save: Name = $studentName, ID = $studentId"
            studentNameEditText.text.clear()
            studentIdEditText.text.clear()
        }

    }
}