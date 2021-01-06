package com.example.green_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun login(view: View) {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this, HomeActivity::class.java))
    }

    fun signUp(view: View) {
        startActivity(Intent(this, signUpActivity::class.java))
    }
}