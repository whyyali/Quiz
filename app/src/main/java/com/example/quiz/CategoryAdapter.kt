package com.example.quiz

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class CategoryAdapter(private val categoryModelList: List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setData(categoryModelList[position].getUrl(), categoryModelList[position].getName())
    }

    override fun getItemCount(): Int {
        return categoryModelList.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: CircleImageView = itemView.findViewById(R.id.imageView)
        private val title: TextView = itemView.findViewById(R.id.title)
         fun setData(url: String , titleValue: String) {
            Glide.with(itemView.context).load(url).into(imageView)
            title.text = titleValue

             itemView.setOnClickListener{
                 val setIntent = Intent(itemView.context, SetsActivity::class.java)
                 setIntent.putExtra("title", titleValue)
                 itemView.context.startActivity(setIntent)
             }
        }


    }

}