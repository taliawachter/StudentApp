package com.example.studentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class StudentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TODO: 1 - Set a ListView in layout
        // TODO: 2- Create an adapter for the ListView
        // TODO: 3 - Connect the ListView with the adapter
        // TODO: 4 - Create a data source for the adopter (e.g.,list of students)
        // TODO: 5 - Create a layout for each item in the ListView

        val student = Model.shared.students

        val listView: ListView = findViewById(R.id.students_list_activity_list_view)
        listView.adapter = StudentListAdapter(
            students = student
        )
    }

    class StudentListAdapter(
        private val students: List<Student>
    ): BaseAdapter() {
        override fun getCount(): Int = students.size

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long = 0

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View {
            val inflator = LayoutInflater.from(parent?.context)

            var view = convertView
            if (convertView == null){
                view = inflator.inflate(R.layout.student_row_layout,parent, false)
                val checkbox: CheckBox = view.findViewById(R.id.checkbox)
                checkbox.setOnClickListener { view ->
                    (view?.tag as? Int)?.let { tag ->
                        students[tag].isPresent = checkbox.isChecked
                    }
                }
            }

            val nameTextView: TextView = view.findViewById(R.id.name_text_view)
            val idTextView: TextView = view.findViewById(R.id.id_text_view)
            val checkBox: CheckBox = view.findViewById(R.id.checkbox)

            nameTextView.text = students[position].name
            idTextView.text = students[position].id
            checkBox.apply {
                isChecked = students[position].isPresent
                tag = position
            }

            return view
        }
    }
}