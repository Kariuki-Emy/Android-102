package com.example.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Buttoncalc:Button
    lateinit var Buttonweb:Button
    lateinit var Buttonint:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Buttoncalc=findViewById(R.id.Btn_calc)
        Buttonweb=findViewById(R.id.Btn_web)
        Buttonint=findViewById(R.id.Btn_intent)
        Buttoncalc.setOnClickListener {
            val cal=android.content.Intent(this,Calculator::class.java)
            startActivity(cal)
        }
        Buttonweb.setOnClickListener {
            val web=android.content.Intent(this,WebActivity::class.java)
            startActivity(web)
        }
        Buttonint.setOnClickListener {
            val int=Intent(this,IntentActivity::class.java)
            startActivity(int)
        }


    }
}