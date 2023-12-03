package com.example.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GridAdapter(private var sets: Int = 0) : BaseAdapter() {

    override fun getCount(): Int {
        return sets
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView?: LayoutInflater.from(parent?.context).inflate(R.layout.set_item, parent, false)
        val  textView = view.findViewById<TextView>(R.id.textview)
        textView.text = (position + 1).toString()
        return view
    }
}