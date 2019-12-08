package com.example.activeu.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activeu.R
import com.example.activeu.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_start.*
import java.util.*

class StartActivity : AppCompatActivity() {
    fun getStore() = getPreferences(Context.MODE_PRIVATE)
    //private lateinit var UserViewModel: UserViewModel
    private var user: String = ""
    var UserKey = "UserKey"

    private fun getUserName() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

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
