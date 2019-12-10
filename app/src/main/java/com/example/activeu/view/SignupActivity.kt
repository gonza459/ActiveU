package com.example.activeu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.activeu.R
import com.example.activeu.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_start.*

class SignupActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java) // unsure of what this line does

        UsernameField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        signupCreate_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra(
                    "username",
                    UsernameField.text
                )
            })
        }
    }
}
