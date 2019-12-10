package com.example.activeu.view

import android.content.Context
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.activeu.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US) // retrieves username of current user from intent extras

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeUserTextView.text = "Welcome back, ${getUsername()}"

        sleepCheckBox.setOnClickListener{
            if (sleepCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        makeBedCheckBox.setOnClickListener{
            if (makeBedCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        threeMealsCheckBox.setOnClickListener{
            if (threeMealsCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        planCheckBox.setOnClickListener{
            if (planCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        alarmCheckBox.setOnClickListener{
            if (alarmCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        exerciseCheckBox.setOnClickListener{
            if (exerciseCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

        meditateCheckBox.setOnClickListener{
            if (meditateCheckBox.isChecked)
                incrementProgressBar()
            else decrementProgressBar()
        }

    }

    private fun incrementProgressBar() {
        progressBar.progress = progressBar.progress + 1
    }

    private fun decrementProgressBar() {
        progressBar.progress = progressBar.progress - 1
    }

    private fun isProgressBarComplete() : Boolean {
        return progressBar.progress == 7
    }

}
