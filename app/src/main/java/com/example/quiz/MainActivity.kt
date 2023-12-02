package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<AppCompatButton>(R.id.startBtn)
        startButton.setOnClickListener{
            val  intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }
    }
}