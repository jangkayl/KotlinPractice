package com.example.employeeapp.ui

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import app.MyApplication
import com.example.employeeapp.R
import java.util.Calendar

class EntryActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entryscreen_activity)

        val btnDate: Button = findViewById(R.id.btn_date)
        val txtSelectedDate: TextView = findViewById(R.id.select_date)
        val inputName: EditText = findViewById(R.id.input_employeeName)
        val inputDepartment: EditText = findViewById(R.id.input_department)
        val inputSalary: EditText = findViewById(R.id.input_salary)
        val inputPassword: EditText = findViewById(R.id.input_password)
        val inputUsername: EditText = findViewById(R.id.input_username)
        val inputRadio: RadioGroup = findViewById(R.id.radio_rating)
        val btnSave: Button = findViewById(R.id.save_button)

        btnDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay)
                txtSelectedDate.text = formattedDate
            }, year, month, day)

            datePicker.show()
        }

        btnSave.setOnClickListener {
            val listOfInputs = listOf(inputName, inputDepartment, inputSalary, inputPassword, inputUsername)
            var isValid = true

            for (field in listOfInputs) {
                if (field.text.isBlank()) {
                    field.error = "Required"
                    isValid = false
                } else {
                    field.error = null
                }
            }

            if (inputRadio.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select a rating!", Toast.LENGTH_LONG).show()
                isValid = false
            }

            println("Date: ${txtSelectedDate.text}")

            if (txtSelectedDate.text == "Select date...") {
                Toast.makeText(this, "Please select a date!", Toast.LENGTH_LONG).show()
                isValid = false
            }

            if (!isValid) return@setOnClickListener

            Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_LONG).show()

            (application as MyApplication).name = inputName.text.toString()
            (application as MyApplication).date = txtSelectedDate.text.toString()
            (application as MyApplication).department = inputDepartment.text.toString()
            (application as MyApplication).rating = inputRadio.checkedRadioButtonId.toString()
            (application as MyApplication).salary = inputSalary.text.toString()
            (application as MyApplication).username = inputUsername.text.toString()
            (application as MyApplication).password = inputPassword.text.toString()

            startActivity(Intent(this, HomeActivity::class.java))

//            startActivity(Intent(this, HomeActivity::class.java).apply {
//                putExtra("name", inputName.text.toString())
//                putExtra("department", inputDepartment.text.toString())
//                putExtra("salary", inputSalary.text.toString())
//                putExtra("date", txtSelectedDate.text.toString())
//                putExtra("rating", inputRadio.checkedRadioButtonId.toString())
//                putExtra("username", inputUsername.text.toString())
//                putExtra("password", inputPassword.text.toString())
//            })
        }

    }
}




