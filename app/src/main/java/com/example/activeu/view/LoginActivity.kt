package com.example.activeu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.activeu.R
import kotlinx.android.synthetic.main.activity_login.*
//import com.example.activeu.viewmodel.CountViewModel
//import com.example.activeu.viewmodel.GifViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.atomic.LongAdder
import java.util.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginUsernameField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?){

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){

            }

            override fun onTextChanged(p0: CharSequence?,p1: Int, p2: Int, p3: Int ){

            }


        })

        login_button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java).apply{putExtra("username", loginUsernameField.text)})
        }


    }
}
