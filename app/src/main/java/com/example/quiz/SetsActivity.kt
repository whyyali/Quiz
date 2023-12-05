package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.GridView
import androidx.appcompat.widget.Toolbar

class SetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sets)

        val toolbar: Toolbar = findViewById(R.id.setsToolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra("title")

        val gridView : GridView = findViewById(R.id.gridView)

        val gridAdapter = GridAdapter(10)
        gridView.adapter = gridAdapter

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
          if (item.itemId == android.R.id.home){
              finish()
          }
        return super.onOptionsItemSelected(item)
    }
}