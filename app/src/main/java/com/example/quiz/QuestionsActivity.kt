package com.example.quiz

import android.animation.Animator
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class QuestionsActivity : AppCompatActivity() {

    private var count = 0
    private var position = 0
    private var score = 0
    private lateinit var noIndicator : TextView
    private lateinit var nextBtn : AppCompatButton
    private lateinit var optionsContainer : LinearLayout
    private val list: MutableList<QuestionModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        optionsContainer = findViewById(R.id.optionsContainer)
        nextBtn = findViewById(R.id.nextButton)
        noIndicator = findViewById(R.id.noIndicator)
        val question : TextView = findViewById(R.id.question)
        val shareBtn : AppCompatButton = findViewById(R.id.shareButton)
        val bookmarkBtn : FloatingActionButton = findViewById(R.id.bookmarkBtn)

        list.add(QuestionModel("question 1", "a", "b","c", "d", "a"))
        list.add(QuestionModel("question 2", "a", "b","c", "d", "c"))
        list.add(QuestionModel("question 3", "a", "b","c", "d", "d"))
        list.add(QuestionModel("question 4", "a", "b","c", "d", "a"))
        list.add(QuestionModel("question 5", "a", "b","c", "d", "c"))
        list.add(QuestionModel("question 6", "a", "b","c", "d", "b"))
        list.add(QuestionModel("question 7", "a", "b","c", "d", "a"))
        list.add(QuestionModel("question 8", "a", "b","c", "d", "d"))
        list.add(QuestionModel("question 9", "a", "b","c", "d", "c"))
        list.add(QuestionModel("question 10", "a", "b","c", "d", "a"))

        for (i in 0 until 4){
         optionsContainer.getChildAt(i).setOnClickListener {
             checkAnswer(it as AppCompatButton)
         }
        }

        playAnimation(question, 0, list[position].getQuestion())
        nextBtn.setOnClickListener {
            nextBtn.isEnabled = false
            nextBtn.alpha = 0.7F
            position++
            enableOption(true)
            if (position == list.size){

            }
            count = 0
            playAnimation(question, 0, list[position].getQuestion())
        }

    }

    private fun playAnimation(view: View, value: Int, data:String) {
        view.animate()
            .alpha(value.toFloat())
            .scaleX(value.toFloat())
            .scaleY(value.toFloat())
            .setDuration(500)
            .setStartDelay(100)
            .setInterpolator(DecelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    if (value == 0 && count < 4 ){
                        var option: String = ""
                        if (count ==0){
                            option = list[position].getOptionA()
                        } else if (count == 1){
                            option = list[position].getOptionB()
                        } else if (count == 2){
                            option = list[position].getOptionC()
                        } else if (count == 3){
                            option = list[position].getOptionD()
                        }
                        playAnimation(optionsContainer.getChildAt(count), 0, option)
                        count++
                    }
                }

                override fun onAnimationEnd(animation: Animator) {
                    if (value == 0) {
                        try {
                            (view as TextView).text = data
                            noIndicator.text = "${position+1}/${list.size}"
                        } catch (e: ClassCastException) {
                            (view as? AppCompatButton)?.text = data
                        }
                        view.tag = data
                        playAnimation(view, 1, data)
                    }
                }
                override fun onAnimationCancel(animation: Animator) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationRepeat(animation: Animator) {
                    TODO("Not yet implemented")
                }

            })
    }

    private fun checkAnswer(selectedOption: AppCompatButton) {
        enableOption(false)
        nextBtn.isEnabled = true
        nextBtn.alpha = 1F
        if (selectedOption.text.toString() == list[position].getCorrectAns()){
            score++
            selectedOption.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#00ff00"))
        } else{
            selectedOption.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#ff0000"))
            val correctOption: AppCompatButton = optionsContainer.findViewWithTag(list[position].getCorrectAns())
            correctOption.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#00ff00"))
        }
    }

    private fun enableOption(enable: Boolean){
        for (i in 0 until 4){
            optionsContainer.getChildAt(i).isEnabled = enable
            if (enable){
                optionsContainer.getChildAt(i).backgroundTintList = ColorStateList.valueOf(Color.parseColor("#e0e0e0"))
            }
        }
    }


}