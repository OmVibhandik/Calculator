package com.example.calculator

import android.media.tv.TvView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException


class MainActivity : AppCompatActivity() {

    private var TvInput:TextView?=null

    var lastno : Boolean = false
    var lastdot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TvInput = findViewById(R.id.TvInput)
    }

    fun onDigit(view: View){
        TvInput?.append((view as Button).text)
        lastno = true

    }

    fun onClear(view: View)
    {
        TvInput?.text=""
        lastno  = false
        lastdot = false
    }

    fun ondecimalpy(view: View) {
        if (lastno && !lastdot)
        {
            TvInput?.append(".")
        lastdot = true
    }}

    fun onOper(view: View)
    {
        if(lastno && !conoperatior(TvInput?.text.toString()))
        TvInput?.append((view as Button).text)
        lastno=false
        lastdot=false
    }
    private fun remzero(result: String):String
    {
        var value = result
        if(result.contains(".0"))
        {
            value= result.substring(0, result.length-2)
        }
        return value
    }

    private fun conoperatior(value: String):Boolean
    {
        return if (value.startsWith("-")) {
                false
        }
            else
            (
                    value.contains("/")||value.contains("+")
                            ||value.contains("*")|| value.contains("-")
            )
    }

    fun onequal(view: View)
    {
        if (lastno)
        {
            var tvView = TvInput?.text.toString()
            var prefix = ""
            try {
                if (tvView.startsWith("-")) {
                    prefix = "-"
                    tvView=tvView.substring(1)
                }
                if (tvView.contains("-"))
                {
                    val splitvalue = tvView.split("-")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    TvInput?.text = remzero((one.toDouble()-two.toDouble()).toString())
                }
                else if (tvView.contains("+"))
                {
                    val splitvalue = tvView.split("+")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    TvInput?.text = remzero((one.toDouble() + two.toDouble()).toString())
                }
                else if (tvView.contains("*"))
                {
                    val splitvalue = tvView.split("*")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    TvInput?.text = remzero((one.toDouble() * two.toDouble()).toString())
                }
                else if (tvView.contains("/"))
                {
                    val splitvalue = tvView.split("/")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    TvInput?.text = remzero((one.toDouble() / two.toDouble()).toString())
                }
             }catch (e: ArithmeticException){
                e.printStackTrace()
             }
        }
    }





}