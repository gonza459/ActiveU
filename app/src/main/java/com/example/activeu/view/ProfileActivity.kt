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
    private var sleep: Boolean = false
    private var eating: Boolean = false
    private var organize: Boolean = false
    private var quit: Boolean = false
    private var exercise: Boolean = false

    private fun getUserName() = intent.extras?.get("username").toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.getUserSleep("${getUserName()}Sleep 8+ hrs").observe(this,
            androidx.lifecycle.Observer {updateSleep(it)})
        userViewModel.getUserHealth("${getUserName()}Better Eating Habits").observe(this,
            androidx.lifecycle.Observer {updateHealth(it)})
        userViewModel.getUserOrganize("${getUserName()}Be More Organized").observe(this,
            androidx.lifecycle.Observer {updateProfileOrganize(it)})
        userViewModel.getUserQuit("${getUserName()}Quit Smoking").observe(this,
            androidx.lifecycle.Observer {updateProfileQuit(it)})
        userViewModel.getUserExercise("${getUserName()}Exercise More").observe(this,
            androidx.lifecycle.Observer {updateProfileExercise(it)})

        saveButton.setOnClickListener {
            if(sleep.isChecked){
                sleep = true
                userViewModel.setUserSleep(getUserName(), sleep)
            }else{
                profileViewModel.setUserProfileDairy(getUserName(), false)
            }

            if(veggie.isChecked){
                isVeggies = true
                profileViewModel.setUserProfileVeggie(getUserName(), isVeggies)
            }else{
                profileViewModel.setUserProfileVeggie(getUserName(), false)
            }

            if(vegan.isChecked){
                isVegans = true
                profileViewModel.setUserProfileVegan(getUserName(), isVegans)
            }else{
                profileViewModel.setUserProfileVegan(getUserName(), false)
            }

            if(gluten.isChecked){
                isGlutens = true
                profileViewModel.setUserProfileGluten(getUserName(), isGlutens)
            }else{
                profileViewModel.setUserProfileGluten(getUserName(), false)
            }


            user = getUserName()
        username.text = "User: ${user.toString()}"

    }
    private fun updateSleep(betterSleep: Boolean) {
        sleep = betterSleep
        if (sleep) {
            sleep.setChecked(true)
        }
    }

}
