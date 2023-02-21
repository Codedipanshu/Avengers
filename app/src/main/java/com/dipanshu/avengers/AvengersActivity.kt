package com.dipanshu.avengers

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    lateinit var btnLogout: Button

    lateinit var sharedPreferences: SharedPreferences
    var titleName: String? = "Avengers"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        titleName = sharedPreferences.getString("Title", "The Avengers")

        title = titleName

        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}