package com.example.quiz
class CategoryModel(private var imageUrl: String, private var title: String) {
    fun getImageUrl(): String {
        return imageUrl
    }
    fun setImageUrl(newImage: String) {
        imageUrl = newImage
    }
    fun getTitle(): String {
        return title
    }
    fun setTitle(newTitle: String) {
        title = newTitle
    }
}