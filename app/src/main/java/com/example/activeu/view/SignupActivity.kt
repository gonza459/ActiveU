package com.example.activeu.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.activeu.R
import com.example.activeu.model.User
import com.example.activeu.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_start.*
import java.util.*

class SignupActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        UsernameField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        signup_button.setOnClickListener {

            userViewModel.getUserPassword("${Username.text}Password").observe(this,
                androidx.lifecycle.Observer { getPass(it) })

            Log.d("user", "password: ${password}")
            if (password == "") {
                var errorMessage = TextView(this)
                errorMessage.text = "Username not valid"
            } else {
                userViewModel.setUserPassword(
                    Username.text.toString(),
                    Password.text.toString()
                )
                startActivity(Intent(this, MainActivity::class.java).apply {
                    putExtra(
                        "username",
                        Username.text
                    )
                })
            }
        }
    }

        private fun getPass(pass: String){
            password = pass

    }
}
