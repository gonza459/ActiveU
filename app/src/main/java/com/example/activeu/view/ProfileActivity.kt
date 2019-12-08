package com.example.activeu.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.activeu.R
import com.example.activeu.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_profile.*
import java.util.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private var user: String = ""
    private var sleepMore: Boolean = false
    private var betterEating: Boolean = false
    private var organizeMore: Boolean = false
    private var quitSmoking: Boolean = false
    private var exerciseMore: Boolean = false

    private fun getUserName() = intent.extras?.get("username").toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.getUserSleep("${getUserName()}Sleep 8+ hrs").observe(this,
            androidx.lifecycle.Observer {updateProfileSleep(it)})
        userViewModel.getUserHealth("${getUserName()}Better Eating Habits").observe(this,
            androidx.lifecycle.Observer {updateProfileHealth(it)})
        userViewModel.getUserOrganize("${getUserName()}Be More Organized").observe(this,
            androidx.lifecycle.Observer {updateProfileOrganize(it)})
        userViewModel.getUserQuit("${getUserName()}Quit Smoking").observe(this,
            androidx.lifecycle.Observer {updateProfileQuit(it)})
        userViewModel.getUserExercise("${getUserName()}Exercise More").observe(this,
            androidx.lifecycle.Observer {updateProfileExercise(it)})

        user = getUserName()
        username.text = "User: ${user.toString()}"

        saveButton.setOnClickListener {
            if (sleep.isChecked) {
                sleepMore = true
                userViewModel.setUserSleep(getUserName(), sleepMore)
            } else {
                userViewModel.setUserSleep(getUserName(), false)
            }

            if (health.isChecked) {
                betterEating = true
                userViewModel.setUserHealth(getUserName(), betterEating)
            } else {
                userViewModel.setUserHealth(getUserName(), false)
            }

            if (organize.isChecked) {
                organizeMore = true
                userViewModel.setUserOrganize(getUserName(), organizeMore)
            } else {
                userViewModel.setUserOrganize(getUserName(), false)
            }

            if (quit.isChecked) {
                quitSmoking = true
                userViewModel.setUserQuit(getUserName(), quitSmoking)
            } else {
                userViewModel.setUserQuit(getUserName(), false)
            }

            if (exercise.isChecked) {
                exerciseMore = true
                userViewModel.setUserExercise(getUserName(), exerciseMore)
            } else {
                userViewModel.setUserExercise(getUserName(), false)
            }
        }

    }

    private fun updateProfileSleep(betterSleep: Boolean) {
        sleepMore = betterSleep
        if (sleepMore) {
            sleep.setChecked(true)
        }
    }
    private fun updateProfileHealth(betterHealth: Boolean) {
        betterEating = betterHealth
        if (betterEating) {
            health.setChecked(true)
        }
    }

    private fun updateProfileOrganize(organizeBetter: Boolean) {
        organizeMore = organizeBetter
        if (organizeMore) {
            organize.setChecked(true)
        }
    }

    private fun updateProfileQuit(NoSmoking: Boolean) {
        quitSmoking = NoSmoking
        if (quitSmoking) {
            quit.setChecked(true)
        }
    }
    private fun updateProfileExercise(betterExercise: Boolean) {
        exerciseMore = betterExercise
        if (exerciseMore) {
            exercise.setChecked(true)
        }
    }

}
