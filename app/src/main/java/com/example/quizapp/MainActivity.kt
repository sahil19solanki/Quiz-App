package com.example.quizapp

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

        val s_Btn:Button=findViewById(R.id.s_Btn)
        val Ip:EditText=findViewById(R.id.Ip)

        s_Btn.setOnClickListener{
           if(Ip.text.isEmpty()){
               Toast.makeText(this, "Give name", Toast.LENGTH_SHORT).show()
           }
            else{
                val intent= Intent(this,Questions::class.java)
               intent.putExtra(q_9.USER_NAME,Ip.text.toString())
                 startActivity(intent)

           }
        }
    }
}