package com.example.activeu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activeu.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        login_button.setOnClickListener{

            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        signup_button.setOnClickListener{

            intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }
}
