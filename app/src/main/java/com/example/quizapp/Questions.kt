package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Questions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<QuesModel>?=null
    private var mSelectedOptionPosition:Int=0
    private var mUserName:String?=null
    private var mCorrectAnswer:Int = 0

    //for finding elements
    private var progressBar: ProgressBar?=null
    private var tvProg: TextView?=null
    private var tvQues:TextView?=null
    private var iView:ImageView?=null

    private var opOne:TextView?=null
    private var opTwo:TextView?=null
    private var opThree:TextView?=null
    private var opFour:TextView?=null
    private var btnSubmit:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(q_9.USER_NAME)

        //finding elements
        progressBar=findViewById(R.id.Prog)
        tvProg=findViewById(R.id.TvProg)
        tvQues=findViewById(R.id.TvQ)
        iView=findViewById(R.id.Iv)
        btnSubmit=findViewById(R.id.btn_sub)

        opOne=findViewById(R.id.tv_op_1)
        opTwo=findViewById(R.id.tv_op_2)
        opThree=findViewById(R.id.tv_op_3)
        opFour=findViewById(R.id.tv_op_4)

        mQuestionList = q_9.getQuestion()
        opOne?.setOnClickListener(this)
        opTwo?.setOnClickListener(this)
        opThree?.setOnClickListener(this)
        opFour  ?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        setQuestion()
        defaultOPtionView()
    }



    private fun setQuestion() {
        defaultOPtionView()
        val question: QuesModel = mQuestionList!![mCurrentPosition - 1]
        iView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProg?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQues?.text = question.question

        opOne?.text = question.opOne
        opTwo?.text = question.opTwo
        opThree?.text = question.opThree
        opFour?.text = question.opFour

        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="Finish"
        }
        else {
            btnSubmit?.text="Submit"
        }
    }

    private fun defaultOPtionView(){
        val options = arrayListOf<TextView>()

        opOne?.let {
            options.add(0,it)
        }
        opTwo?.let {
            options.add(1,it)
        }
        opThree?.let {
            options.add(2,it)
        }
        opFour?.let{
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
           this,R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOption(v:TextView,optionNum:Int){
        defaultOPtionView()

        mSelectedOptionPosition=optionNum

        v.setTextColor(Color.parseColor("#363A43"))
        v.setTypeface(v.typeface,Typeface.BOLD)
        v.background=ContextCompat.getDrawable(
            this,R.drawable.selected_bg

        )
    }
    override fun onClick(view: View?) {
       when(view?.id){
           R.id.tv_op_1->{
            opOne?.let {
                selectedOption(it,1)
            }
           }
           R.id.tv_op_2->{
               opTwo?.let {
                   selectedOption(it,2)
               }
           }
           R.id.tv_op_3->{
               opThree?.let {
                   selectedOption(it,3)
               }
           }
           R.id.tv_op_4->{
               opFour?.let {
                   selectedOption(it,4)
               }
           }
           R.id.btn_sub->{
                    if(mSelectedOptionPosition==0){
                        mCurrentPosition++

                        when{
                            mCurrentPosition <=mQuestionList!!.size ->{
                                setQuestion()
                            }
                            else ->{
                               val intent = Intent(this,Result_activity::class.java)
                                intent.putExtra(q_9.USER_NAME,mUserName)
                                intent.putExtra(q_9.CORRECT_ANSWER,mCorrectAnswer)
                                intent.putExtra(q_9.Total_Q,mQuestionList?.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }else{
                        val question = mQuestionList?.get(mCurrentPosition-1)
                        if(question!!.Cans!=mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition,R.drawable.wrong_bg)
                        }else{
                            mCorrectAnswer++
                        }
                        answerView(question.Cans,R.drawable.correct_bg)
                        if(mCurrentPosition == mQuestionList!!.size){
                            btnSubmit?.text="FINSH"
                        }else{
                            btnSubmit?.text="NEXT QUESTION"
                        }
                        mSelectedOptionPosition=0
                    }
           }
       }
    }

    private fun answerView(answer:Int,drawable:Int){
        when(answer){
            1 ->{
                opOne?.background=ContextCompat.getDrawable(this,drawable)
            }
            2 ->{
                opTwo?.background=ContextCompat.getDrawable(this,drawable)
            }
            3 ->{
                opThree?.background=ContextCompat.getDrawable(this,drawable)
            }
            4 ->{
                opFour?.background=ContextCompat.getDrawable(this,drawable)
            }
        }
    }
}