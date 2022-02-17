package com.example.ageinminuteapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var submitted: Boolean = false;
    private var currentIndex: Int = 1
    private var mselectedOption: Int = 0
    private var correctAnswers: Int = 0
    private var listOfQuestions: ArrayList<Question>? = null
    private var questionText: TextView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var mUsername: String? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var progressBar: ProgressBar? = null
    private var image: ImageView? = null
    private var btn_submit: Button? = null
    private var questionStatusText: TextView? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        listOfQuestions = Constants.getQuestions()

        /**
         * Initializing fields of ui elements in kotlin
         */
        image = findViewById(R.id.iv_image)
        questionText = findViewById(R.id.question)
        tvOption1 = findViewById(R.id.tv_option_1)
        tvOption2 = findViewById(R.id.tv_option_2)
        tvOption3 = findViewById(R.id.tv_option_3)
        tvOption4 = findViewById(R.id.tv_option_4)
        mUsername = intent.getStringExtra(Constants.USER)
        progressBar = findViewById(R.id.progress_bar)
        questionStatusText = findViewById(R.id.tv_progress)
        btn_submit = findViewById(R.id.btn_submit)
        setQuestion()
        if (mselectedOption == listOfQuestions!!.size - 1) {
            btn_submit?.text = "Finish"
        } else {
            btn_submit?.text = "Submit"
        }

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)

    }

    private fun clearSelectedOptions() {
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.border_surrounding_buttons)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        clearSelectedOptions()
        val question = listOfQuestions!![currentIndex - 1]
        questionText?.text = question.question
        questionStatusText?.text = "$currentIndex / ${listOfQuestions?.size}"
        tvOption1?.text = question.option1
        progressBar?.progress = currentIndex
        image?.setImageResource(question.image)
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4
    }

    private fun selectedOptionView(tvView: TextView?, selectedOption: Int) {
        clearSelectedOptions()
        mselectedOption = selectedOption
        tvView?.setTextColor(Color.parseColor("#000000"))
        tvView?.setTypeface(tvView.typeface, Typeface.BOLD)
        tvView?.background =
            ContextCompat.getDrawable(this, R.drawable.selected_button_border)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOption1?.background =
                ContextCompat.getDrawable(this, drawableView)
            2 -> tvOption2?.background =
                ContextCompat.getDrawable(this, drawableView)
            3 -> tvOption3?.background =
                ContextCompat.getDrawable(this, drawableView)
            4 -> tvOption4?.background =
                ContextCompat.getDrawable(this, drawableView)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_1 ->
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }
            R.id.tv_option_2 -> tvOption2?.let {
                selectedOptionView(it, 2)
            }
            R.id.tv_option_3 -> tvOption3?.let {
                selectedOptionView(tvOption3, 3)
            }

            R.id.tv_option_4 -> tvOption4?.let {
                selectedOptionView(it, 4)
            }
            R.id.btn_submit -> btn_submit?.let {
                if (mselectedOption == 0) {

                    when {
                        currentIndex < listOfQuestions!!.size ->
                            if (currentIndex == 0 || submitted) {
                                currentIndex++
                                btn_submit?.text = "Submit"
                                setQuestion()
                                submitted = false

                            } else Toast.makeText(
                                this, "Duhet zgjedhur nje alternative",
                                Toast.LENGTH_LONG
                            ).show()

                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.NUMBER_OF_QUESTIONS, listOfQuestions!!.size)
                            intent.putExtra(Constants.USER, mUsername)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = listOfQuestions!![currentIndex - 1]
                    if (question.correctAnswer != mselectedOption) {
                        answerView(mselectedOption, R.drawable.wrong_button_background)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.selected_option_background)

                    if (currentIndex < listOfQuestions!!.size) {
                        btn_submit?.text = "Go to next question"
                    } else {
                        btn_submit?.text = "Finish"
                    }
                    submitted = true;
                    mselectedOption = 0

                }


            }
        }
    }

}