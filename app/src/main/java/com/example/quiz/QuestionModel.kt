package com.example.quiz

class QuestionModel(ques:String, a: String, b:String, c:String, d:String, correctAnswer:String ) {
    private var question: String = ques
    private var optionA: String = a
    private var optionB: String = b
    private var optionC: String = c
    private var optionD: String = d
    private var correctAns : String = correctAnswer

    fun getQuestion(): String {
        return question
    }

    fun setQuestion(value: String) {
        question = value
    }

    fun getOptionA(): String {
        return optionA
    }

    fun setOptionA(value: String) {
        optionA = value
    }

    fun getOptionB(): String {
        return optionB
    }

    fun setOptionB(value: String) {
        optionB = value
    }

    fun getOptionC(): String {
        return optionC
    }

    fun setOptionC(value: String) {
        optionC = value
    }

    fun getOptionD(): String {
        return optionD
    }

    fun setOptionD(value: String) {
        optionD = value
    }

    fun getCorrectAns(): String {
        return correctAns
    }

    fun setCorrectAns(value: String) {
        correctAns = value
    }
}