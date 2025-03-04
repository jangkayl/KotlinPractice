package com.example.employeeapp.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import app.MyApplication
import com.example.employeeapp.R

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val name: TextView = findViewById(R.id.op_name)
        val department: TextView = findViewById(R.id.op_department)
        val salary: TextView = findViewById(R.id.op_salary)
        val date: TextView = findViewById(R.id.op_date)
        val rating: TextView = findViewById(R.id.op_rating)
        val username: TextView = findViewById(R.id.op_username)
        val password: TextView = findViewById(R.id.op_password)

        name.text = (application as MyApplication).name
        department.text = (application as MyApplication).department
        salary.text = (application as MyApplication).salary
        date.text = (application as MyApplication).date
        rating.text = (application as MyApplication).rating
        username.text = (application as MyApplication).username
        password.text = (application as MyApplication).password

//        intent?.let {
//            it.getStringExtra("name")?.let { intentName ->
//                name.text = intentName
//            }
//            it.getStringExtra("department")?.let { intentDepartment ->
//                department.text = intentDepartment
//            }
//            it.getStringExtra("salary")?.let { intentSalary ->
//                salary.text = intentSalary
//            }
//            it.getStringExtra("date")?.let { intentDate ->
//                date.text = intentDate
//            }
//            it.getStringExtra("rating")?.let { intentRating ->
//                rating.text = intentRating
//            }
//            it.getStringExtra("username")?.let { intentUsername ->
//                username.text = intentUsername
//            }
//            it.getStringExtra("password")?.let { intentPassword ->
//                password.text = intentPassword
//            }
//        }
    }
}