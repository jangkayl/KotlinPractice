package app

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    var name: String = ""
    var department: String = ""
    var salary: String = ""
    var date: String = ""
    var rating: String = ""
    var username: String = ""
    var password: String = ""

    override fun onCreate(){
        super.onCreate()
        Log.e("Tutorial", "My application is called")
    }
}