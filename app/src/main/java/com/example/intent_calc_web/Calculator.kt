package com.example.intent_calc_web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Calculator : AppCompatActivity() {
    lateinit var Txtans: TextView
    lateinit var edtfirnum: EditText
    lateinit var edtsecnum: EditText
    lateinit var buttonadd: Button
    lateinit var buttonsub: Button
    lateinit var buttonmult: Button
    lateinit var buttondiv: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        Txtans = findViewById(R.id.tv_ans)
        edtfirnum = findViewById(R.id.edt_fnum)
        edtsecnum = findViewById(R.id.edt_snum)
        buttonadd = findViewById(R.id.Btn_add)
        buttonsub = findViewById(R.id.Btn_sub)
        buttonmult = findViewById(R.id.Btn_mult)
        buttondiv = findViewById(R.id.Btn_div)

        buttonadd.setOnClickListener {
            val firstnum = edtfirnum.text.toString()
            val secnum = edtsecnum.text.toString()
            if (firstnum.isEmpty() && secnum.isEmpty()) {
                Txtans.text = "Please fill in all detail"
            } else {
                var answer = firstnum.toDouble() + secnum.toDouble()
                Txtans.text = answer.toString()
            }
        }
        buttonsub.setOnClickListener {
            val firstnum = edtfirnum.text.toString()
            val secnum = edtsecnum.text.toString()
            if (firstnum.isEmpty() && secnum.isEmpty()) {
                Txtans.text = "Please fill in all detail"
            } else {
                var answer = firstnum.toDouble() - secnum.toDouble()
                Txtans.text = answer.toString()
            }
        }
        buttonmult.setOnClickListener {
            val firstnum = edtfirnum.text.toString()
            val secnum = edtsecnum.text.toString()
            if (firstnum.isEmpty() && secnum.isEmpty()) {
                Txtans.text = "Please fill in all detail"
            } else {
                var answer = firstnum.toDouble() * secnum.toDouble()
                Txtans.text = answer.toString()
            }
        }
        buttondiv.setOnClickListener {
            val firstnum = edtfirnum.text.toString()
            val secnum = edtsecnum.text.toString()
            if (firstnum.isEmpty() && secnum.isEmpty()) {
                Txtans.text = "Please fill in all detail"
            } else {
                var answer = firstnum.toDouble() / secnum.toDouble()
                Txtans.text = answer.toString()
            }
        }


    }
}