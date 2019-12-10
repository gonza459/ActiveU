package com.example.activeu.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activeu.R
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

        val username = intent.extras?.get("username").toString().trim()
        UserKey = username

       // UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        //UserViewModel.getUserCount((getUserName())).observe(this,
         //   androidx.lifecycle.Observer { updateCounter(it) })

        addHealthButton.setOnClickListener{
            incrementProgressBar()
        }

        subHealthButton.setOnClickListener{
            incrementProgressBar()
        }

        addExerciseButton.setOnClickListener{
            incrementProgressBar()
        }

        subExerciseButton.setOnClickListener{
            incrementProgressBar()
        }

        addOrgButton.setOnClickListener{
            incrementProgressBar()
        }

        subOrgButton.setOnClickListener{
            incrementProgressBar()
        }

        addQuitButton.setOnClickListener{
            incrementProgressBar()
        }

        subQuitButton.setOnClickListener{
            incrementProgressBar()
        }
    }

    private fun incrementProgressBar() {
        progressBar.progress = progressBar.progress + 1
    }

    private fun decrementProgressBar() {
        progressBar.progress = progressBar.progress - 1
    }

}
