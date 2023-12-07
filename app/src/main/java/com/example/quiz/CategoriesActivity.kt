package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CategoriesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: MutableList<CategoryModel>
    private val database = FirebaseDatabase.getInstance()
    private val myRef : DatabaseReference = database.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val toolBar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolBar)
        supportActionBar?.title = "Categories"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

         list = mutableListOf()
        val adapter = CategoryAdapter(list)
        recyclerView.adapter = adapter

        myRef.child("Categories").child("category1").child("name").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (categorySnapshot in dataSnapshot.children){
                    val name = categorySnapshot.child("name").getValue(String::class.java) ?: ""
                    val sets = categorySnapshot.child("sets").getValue(Int::class.java) ?: 0
                    val url = categorySnapshot.child("url").getValue(String::class.java) ?: ""

                    val category = CategoryModel(name, sets, url)
                    list.add(category)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@CategoriesActivity, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }




}