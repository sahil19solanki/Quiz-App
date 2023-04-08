package com.example.quizapp

object q_9 {

    var USER_NAME:String="user_name"
    var CORRECT_ANSWER:String="0"
    var Total_Q:String="0"
    fun getQuestion():ArrayList<QuesModel>{
    val QList=ArrayList<QuesModel>()


        val q1=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia","Belgium","Brazil",1
        )
        val q2=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_australia,
            "Argentina","Australia","Belgium","Brazil",2
        )
        val q3=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_belgium,
            "Belgium","Australia","Argentina","Brazil",1
        )
        val q4=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_brazil,
            "Argentina","Australia","Belgium","Brazil",4
        )
        val q5=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_denmark,
            "Denmark","Germany","Belgium","Brazil",1
        )
        val q6=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_fiji,
            "Argentina","New Zealand","figi","Brazil",3
        )
        val q7=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_germany,
            "Germany","New Zealand","figi","Ukrane",1
        )
        val q8=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_india,
            "Germany","Russia","India","Ukrane",3
        )
        val q9=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_kuwait,
            "Germany","Ukrane","India","Kuwait",4
        )
        val q10=QuesModel(
            1,"what is the name of the country in the flag",
            R.drawable.ic_flag_of_new_zealand,
            "Germa ny","New Zealand","India","Kuwait",2
        )
        QList.add(q1)
        QList.add(q2)
        QList.add(q3)
        QList.add(q4)
        QList.add(q5)
        QList.add(q6)
        QList.add(q7)
        QList.add(q8)
        QList.add(q9)
        QList.add(q10)

        return QList

    }
}