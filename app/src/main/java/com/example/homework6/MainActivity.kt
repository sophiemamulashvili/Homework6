package com.example.homework6

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
private lateinit var sharedPreferences: SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE)
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val firstname = sharedPreferences.getString("firstname", "")
        val lastname = sharedPreferences.getString("lastname", "")
        val age = sharedPreferences.getInt("age", 0)
        val address = sharedPreferences.getString("adress", "")

        emailET.setText(email)
        first_nameET.setText(firstname)
        last_nameET.setText(lastname)
        ageET.setText(age.toString())
        addressET.setText(address)
    }


    fun save(view: View){ save.setOnClickListener {
        var Email = emailET.text.toString()
        var Firstname = first_nameET.text.toString()
        var Lastname = last_nameET.text.toString()
        var Age = ageET.text.toString().toInt()
        var Adress = addressET.text.toString()

        if (emailET.text.isNotEmpty() && first_nameET.text.isNotEmpty() && last_nameET.text.isNotEmpty()
                && ageET.text!!.isNotEmpty() && addressET.text.isNotEmpty()
        ) {
            val edit = sharedPreferences.edit()
            edit.putString("Email", Email)
            edit.putString("Firstname", Firstname)
            edit.putString("Lasttname", Lastname)
            edit.putString("Adress", Adress)
            edit.putInt("Age", Age)
            edit.apply()
            Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please, fill all the fields!", Toast.LENGTH_SHORT).show()
        }
    }

    }
}