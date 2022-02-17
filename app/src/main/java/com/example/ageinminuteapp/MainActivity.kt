package com.example.ageinminuteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val btn_Enter: Button = findViewById(R.id.btnEnter)
		val text_name: EditText = findViewById(R.id.text_name)
		btn_Enter.setOnClickListener {
			if (text_name.text.isEmpty()) {
				Toast.makeText(this,"Fusha e emrit nuk mund te jete bosh",Toast.LENGTH_LONG).show()
			}else{
				val i= Intent(this,QuestionActivity::class.java)
				i.putExtra(Constants.USER,text_name.text.toString())
				startActivity(i)
				finish()
			}
			}
		}


	}