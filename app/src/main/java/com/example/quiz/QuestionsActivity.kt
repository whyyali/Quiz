package com.example.quiz

import android.animation.Animator
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
    private lateinit var optionsContainer : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        optionsContainer = findViewById(R.id.optionsContainer)
        val question : TextView = findViewById(R.id.question)
        val noIndicator : TextView = findViewById(R.id.noIndicator)
        val shareBtn : AppCompatButton = findViewById(R.id.shareButton)
        val nextBtn : AppCompatButton = findViewById(R.id.nextButton)
        val bookmarkBtn : FloatingActionButton = findViewById(R.id.bookmarkBtn)

        nextBtn.setOnClickListener {
            count = 0
            playAnimation(question, 0)
        }

    }

    private fun playAnimation(view: View, value: Int) {
        view.animate()
            .alpha(value.toFloat())
            .scaleX(value.toFloat())
            .scaleY(value.toFloat())
            .setDuration(500)
            .setStartDelay(100)
            .setInterpolator(DecelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    if (value == 0 && count < 4){
                        playAnimation(optionsContainer.getChildAt(count), 0)
                        count++
                    }
                }

                override fun onAnimationEnd(animation: Animator) {
                    if (value == 0){
                        playAnimation(view, 1)
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


}