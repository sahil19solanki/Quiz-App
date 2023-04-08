package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvname: TextView = findViewById(R.id.Tvname)
        val score: TextView = findViewById(R.id.score)
        val btn: Button =  findViewById(R.id.finish)


        val total_q=intent.getIntExtra(q_9.Total_Q,0)
        val correctans=intent.getIntExtra(q_9.CORRECT_ANSWER,0)

        tvname.text=intent.getStringExtra(q_9.USER_NAME)

        score.text="your score is $correctans/$total_q"

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}