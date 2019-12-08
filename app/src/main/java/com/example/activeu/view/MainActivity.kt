package com.example.activeu.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activeu.R
import com.example.activeu.model.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    fun getStore() = getPreferences(Context.MODE_PRIVATE)
    //private lateinit var UserViewModel: UserViewModel
    private var user: String = ""
    var UserKey = "UserKey"

    private fun getUserName() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usrname = intent.extras?.get("username").toString().trim()
        UserKey = usrname

       // UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        //UserViewModel.getUserCount((getUserName())).observe(this,
         //   androidx.lifecycle.Observer { updateCounter(it) })

    }
}
