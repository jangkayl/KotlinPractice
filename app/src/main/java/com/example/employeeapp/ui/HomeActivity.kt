package com.example.employeeapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import app.MyApplication
import com.example.employeeapp.R

class HomeActivity : Activity() {

    private lateinit var name: TextView
    private lateinit var department: TextView
    private lateinit var salary: TextView
    private lateinit var date: TextView
    private lateinit var rating: TextView
    private lateinit var username: TextView
    private lateinit var password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        name = findViewById(R.id.op_name)
        department = findViewById(R.id.op_department)
        salary = findViewById(R.id.op_salary)
        date = findViewById(R.id.op_date)
        rating = findViewById(R.id.op_rating)
        username = findViewById(R.id.op_username)
        password = findViewById(R.id.op_password)

        val editProfile: Button = findViewById(R.id.edit_profile)

        editProfile.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {
        val app = application as MyApplication
        name.text = app.name
        department.text = app.department
        salary.text = app.salary
        date.text = app.date
        rating.text = app.rating
        username.text = app.username
        password.text = app.password
    }
}
