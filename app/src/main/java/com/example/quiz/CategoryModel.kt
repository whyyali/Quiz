package com.example.quiz
class CategoryModel(private var name: String, private var sets: Int, private var url: String) {

    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }

    fun getSets(): Int {
        return sets
    }

    fun setSets(newSets: Int) {
        sets = newSets
    }

    fun getUrl(): String {
        return url
    }

    fun setUrl(newUrl: String) {
        url = newUrl
    }
}