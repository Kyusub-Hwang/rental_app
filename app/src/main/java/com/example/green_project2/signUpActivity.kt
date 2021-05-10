package com.example.green_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class signUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun registerDone(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
    }
}