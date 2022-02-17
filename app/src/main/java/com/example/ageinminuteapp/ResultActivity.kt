package com.example.ageinminuteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        findViewById<TextView>(R.id.name)?.text=intent.getStringExtra(Constants.USER)
        findViewById<TextView>(R.id.guessed)?.text="You guessed ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)} out of ${intent.getIntExtra(Constants.NUMBER_OF_QUESTIONS,0)}"
        val btnFinish:Button=findViewById<Button>(R.id.btn_finish)
        btnFinish.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}