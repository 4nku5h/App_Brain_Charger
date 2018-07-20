package com.example.nikhil.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var btn_0:Button
    lateinit var btn_1:Button
    lateinit var btn_2:Button
    lateinit var btn_3:Button
    lateinit var tv_correct_answer_record:TextView   //  5/10  (5 out of 10) View
    lateinit var tv_answer:TextView
    lateinit var tv_timer :TextView
    lateinit var layout_your_score:ConstraintLayout
    lateinit var tv_score:TextView
    lateinit var layout_brain:ConstraintLayout
    var right_answer_location:Int=0
    lateinit var btn_play:Button
    var rand:Random= Random()
    var right_answers:Int=0
    var total_answers:Int=0
    var brain_screen_show=true
    lateinit var tv_outstanding:TextView
    lateinit var tv_wrong_wright:TextView
    var refresher=0

    lateinit var tv_screw_1:TextView
    lateinit var tv_screw_2:TextView
    lateinit var tv_screw_3:TextView
    lateinit var tv_screw_4:TextView



    fun CountTimer(view: View){

           tv_wrong_wright.text=""
        layout_your_score.visibility=View.INVISIBLE
        layout_brain.visibility=View.INVISIBLE
         tv_timer.text="60s"
         right_answers=0
         total_answers=0
        tv_outstanding.visibility=View.INVISIBLE
        tv_correct_answer_record.text=right_answers.toString() +"/"+total_answers

        var tv_timer=findViewById<TextView>(R.id.tv_timer)
        object : CountDownTimer(60000, 1000) {


            override fun onTick(millisUntilFinished: Long) {


                tv_timer.text=((millisUntilFinished / 1000)).toString()

            }

            override fun onFinish() {


                if(right_answers>=20&&total_answers<=35){
                    tv_outstanding.visibility=View.VISIBLE

                    tv_screw_1.animate().rotationBy(36000000F).setDuration(10000)
                    tv_screw_2.animate().rotationBy(36000000F).setDuration(10000)
                    tv_screw_3.animate().rotationBy(36000000F).setDuration(10000)
                    tv_screw_4.animate().rotationBy(36000000F).setDuration(10000)

                }
                tv_screw_1.animate().rotationBy(36000F).setDuration(2000)
                tv_screw_2.animate().rotationBy(36000F).setDuration(2000)
                tv_screw_3.animate().rotationBy(36000F).setDuration(2000)
                tv_screw_4.animate().rotationBy(36000F).setDuration(2000)

                tv_score.text =right_answers.toString() +"/"+total_answers
                layout_your_score.visibility=View.VISIBLE
                layout_brain.visibility=View.VISIBLE
                brain_screen_show=true


            }
        }.start()


    }


    fun answer_grid_maker(){


        var p:Int=rand.nextInt(501)
        var q:Int=rand.nextInt(501)
        var s:Int=rand.nextInt(501)
        //

        var a=rand.nextInt(251)
        var b=rand.nextInt(251)

        var generator=rand.nextInt(3)
        tv_answer.text=( a.toString()+" + "+b.toString())


        while( p==(a+b)) {
            p = rand.nextInt(501)

        }

        while(q==(a+b)){
            q = rand.nextInt(501)
        }

        while(s==(a+b)){
            s = rand.nextInt(501)

        }

        if(generator==0)
        {
            right_answer_location=0
            btn_0.text=(a+b).toString()   //main

            btn_1.text=p.toString()
            btn_2.text=q.toString()
            btn_3.text=s.toString()

        }
        else
            if(generator==1)
            {
                right_answer_location=1
                btn_1.text=(a+b).toString()    //main

                btn_0.text=p.toString()
                btn_2.text=q.toString()
                btn_3.text=s.toString()
            }
            else
                if(generator==2)
                {
                    right_answer_location=2
                    btn_2.text=(a+b).toString()     //main

                    btn_1.text=p.toString()
                    btn_0.text=q.toString()
                    btn_3.text=s.toString()
                }
                else
                    if(generator==3)
                    {
                        right_answer_location=3
                        btn_3.text=(a+b).toString()     //main

                        btn_1.text=p.toString()
                        btn_2.text=q.toString()
                        btn_0.text=s.toString()
                    }

    }



    fun write_answer_checker_on_click(view: View){                                   //wright_answer_checker function runs when any answer is clicked

        if(right_answer_location==view.getTag().toString().toInt()){


            total_answers++
            right_answers++
            tv_correct_answer_record.text=right_answers.toString() +"/"+total_answers
            tv_wrong_wright.text="Right"
            tv_wrong_wright.resources.getColor(R.color.material_grey_300)

        }
        else{

            total_answers++
            tv_correct_answer_record.text=right_answers.toString() +"/"+total_answers
            tv_wrong_wright.text="Wrong"
        }
        answer_grid_maker()                             // calling  answer_grid_maker()  to make grid of  next right and wrong answers
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btn_0=findViewById<Button>(R.id.btn_0)
         btn_1=findViewById<Button>(R.id.btn_1)
         btn_2=findViewById<Button>(R.id.btn_2)
         btn_3=findViewById<Button>(R.id.btn_3)
        tv_answer=findViewById(R.id.tv_answer)
        tv_correct_answer_record=findViewById(R.id.tv_correct_answer_record)
        layout_your_score=findViewById(R.id.layout_your_score)
        layout_brain=findViewById(R.id.layout_brain)
        tv_score=findViewById(R.id.tv_score)
        btn_play=findViewById(R.id.btn_play)
        tv_timer=findViewById(R.id.tv_timer)
        tv_outstanding=findViewById(R.id.tv_outstanding)
        tv_wrong_wright=findViewById(R.id.tv_wrong_wright)
        tv_screw_1=findViewById(R.id.tv_screw_1)
        tv_screw_2=findViewById(R.id.tv_screw_2)
        tv_screw_3=findViewById(R.id.tv_screw_3)
        tv_screw_4=findViewById(R.id.tv_screw_4)




        answer_grid_maker()



        // calling  answer_grid_maker()  to make grid of right and wrong answers

    }
}


//       #@cker's Studio
            //      By Ankush Shriastava