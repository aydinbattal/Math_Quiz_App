package com.example.a1_mathquiz.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a1_mathquiz.entities.Question
import com.example.a1_mathquiz.enums.DifficultyMode
import kotlin.random.Random

/**
 * A1-MathQuiz created by aydin
 * student ID : 991521740
 * on 2022-02-07 */
class Fragment2ViewModel(difficulty: DifficultyMode): ViewModel() {
    var questionsList:MutableList<Question> = ArrayList()
    var isQuizOver: LiveData<Boolean>? = null
    var currentQuestion:Question? = null
    var score:Int = 0
    var difficultyLevel = difficulty

    fun generateQuestions(){
        val a = Random.nextInt(1, 10)
        val b = Random.nextInt(1, 10)

        if(difficultyLevel == DifficultyMode.EASY){
            val answer = a * b
            val wrongAnswer = Random.nextInt(answer-3, answer-1)
            currentQuestion = Question("What is $a+$b?",answer,listOf(answer,wrongAnswer))
        } else if (difficultyLevel == DifficultyMode.CHALLENGE){
            val answer = b*(a+b)-a
            val wrongAnswer = Random.nextInt(answer-3, answer-1)
            currentQuestion = Question("What is $b*($a+$b)-$a?",answer,listOf(answer,wrongAnswer))
        }
    }

}