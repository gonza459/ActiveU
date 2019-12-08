package com.example.activeu.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.example.activeu.UserRepository
import com.example.activeu.R
import java.util.*

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application.applicationContext)

    fun setUserPassword(name: String, pass: String) = repository.setUserProfilePass(name, pass)

    fun setUserSleep(name: String, sleep: Boolean) = repository.setUserSleep(name, sleep)

    fun setUserHealth(name: String, health: Boolean) = repository.setUserHealth(name, health)

    fun setUserOrganize(name: String, organize: Boolean) = repository.setUserOrganize(name, organize)

    fun setUserQuit(name: String, health: Boolean) = repository.setUserHealth(name, health)

    fun setUserExercise(name: String, exercise: Boolean) = repository.setUserExercise(name, exercise)


    fun getUserPassword(name: String) = repository.getUserProfilePass(name)

    fun getUserSleep(name: String) = repository.getUserSleep(name)

    fun getUserHealth(name: String) = repository.getUserHealth(name)

    fun getUserOrganize(name: String) = repository.getUserOrganize(name)

    fun getUserQuit(name: String) = repository.getUserQuit(name)

    fun getUserExercise(name: String) = repository.getUserExercise(name)

}

