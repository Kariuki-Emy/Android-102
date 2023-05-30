package com.example.intent_calc_web

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import androidx.core.content.PackageManagerCompat

class IntentActivity : AppCompatActivity() {
    lateinit var BtnCam:Button
    lateinit var BtnSms:Button
    lateinit var BtnShare:Button
    lateinit var BtnEmail:Button
    lateinit var BtnCall:Button
    lateinit var BtnDial:Button
    lateinit var BtnMpesa:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        BtnCam=findViewById(R.id.Btn_Camera)
        BtnSms=findViewById(R.id.Btn_sms)
        BtnShare=findViewById(R.id.Btn_Share)
        BtnEmail=findViewById(R.id.Btn_email)
        BtnCall=findViewById(R.id.Btn_call)
        BtnDial=findViewById(R.id.Btn_dial)
        BtnMpesa=findViewById(R.id.Btn_mpesa)

        BtnCam.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }
//        BtnSms.setOnClickListener {
//            val uri=Uri.parse("smsto:78036337")
//            val intent=Intent(Intent.ACTION_SENDTO,uri)
//            intent.putExtra("Good Afternoon", "How are you doing today?")
//        }
        BtnSms.setOnClickListener {
            val uri=Uri.parse("smsto:+918511812660")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Good Afternoon","How are you doing today?")
        }
        BtnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }
        BtnEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        BtnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        BtnDial.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }
        BtnMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }

    }
}