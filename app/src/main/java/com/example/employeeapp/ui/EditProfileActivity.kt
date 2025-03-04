package com.example.employeeapp.ui

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import app.MyApplication
import com.example.employeeapp.R
import java.util.Calendar

class EditProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editprofile_activity)

        val back: Button = findViewById(R.id.edit_profile_back)
        val editName: EditText = findViewById(R.id.edit_name)
        val editDepartment: EditText = findViewById(R.id.edit_department)
        val editDate: TextView = findViewById(R.id.edit_date)
        val editRating: RadioGroup = findViewById(R.id.edit_rating)
        val editSalary: EditText = findViewById(R.id.edit_salary)
        val editUsername: EditText = findViewById(R.id.edit_username)
        val editPassword: EditText = findViewById(R.id.edit_password)
        val saveButton: Button = findViewById(R.id.edit_save_button)
        val editButtonDate: Button = findViewById(R.id.edit_btn_date)

        val editRatingTemp: RadioGroup = findViewById(R.id.edit_rating)
        val editDateTemp: TextView = findViewById(R.id.edit_date)

        val app = (application as MyApplication)

        if (app.name.isNotEmpty()) editName.hint = app.name
        if (app.department.isNotEmpty()) editDepartment.hint = app.department
        if (app.date.isNotEmpty()) editDate.text = app.date
        if (app.salary.isNotEmpty()) editSalary.hint = app.salary
        if (app.username.isNotEmpty()) editUsername.hint = app.username
        if (app.password.isNotEmpty()) editPassword.hint = app.password

        editButtonDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay)
                editDate.text = formattedDate
            }, year, month, day)

            datePicker.show()
        }


        if (app.rating.isNotEmpty()) {
            val selectedRating = app.rating.toIntOrNull()
            if (selectedRating != null) {
                val radioButtonId = when (selectedRating) {
                    1 -> R.id.radio1
                    2 -> R.id.radio2
                    3 -> R.id.radio3
                    4 -> R.id.radio4
                    5 -> R.id.radio5
                    else -> -1
                }
                if (radioButtonId != -1) {
                    editRating.check(radioButtonId)
                }
            }
        }

        saveButton.setOnClickListener{
            val listOfInputs = listOf(editName, editDepartment, editSalary, editPassword, editUsername)
            var isValid = false

            for (field in listOfInputs) {
                if (field.text.isNotBlank()) {
                    isValid = true
                    break
                }
            }

            if (editRating.checkedRadioButtonId != editRatingTemp.checkedRadioButtonId) {
                isValid = true
            }

            if (editDate.text != editDateTemp.text) {
                isValid = true
            }

            if(!isValid) {
                Toast.makeText(this, "Nothing to change here!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val app = application as MyApplication

            editName?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.name = it }
            editDate?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.date = it }
            editDepartment?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.department = it }
            editSalary?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.salary = it }
            editUsername?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.username = it }
            editPassword?.text?.toString()?.takeIf { it.isNotEmpty() }?.let { app.password = it }
            recreate()

            val selectedRadioId = editRating?.checkedRadioButtonId
            if (selectedRadioId != null && selectedRadioId != -1) {
                app.rating = selectedRadioId.toString()
            }

            Toast.makeText(this, "Saved changes successfully!", Toast.LENGTH_LONG).show()

            finish()
        }

        back.setOnClickListener {
            finish()
        }
    }
}