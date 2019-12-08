package com.example.activeu

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import me.ibrahimsn.library.LiveSharedPreferences

class UserRepository(context: Context) {

    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    init {
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = LiveSharedPreferences(preferences)
    }

    //function to set the user count in storage
    fun setUserPassword(name: String, password: String) {
        preferences.edit().putString("${name}Password", password).apply()
    }

    fun setUserSleep(name: String, sleep: Boolean) {
        preferences.edit().putBoolean("${name}Sleep 8+ hrs", sleep).apply()
    }

    fun setUserHealth(name: String, health: Boolean) {
        preferences.edit().putBoolean("${name}Better Eating Habits", health).apply()
    }

    fun setUserOrganize(name: String, organize: Boolean) {
        preferences.edit().putBoolean("${name}Be More Organized", organize).apply()
    }

    fun setUserQuit(name: String, quit: Boolean) {
        preferences.edit().putBoolean("${name}Quit Smoking", quit).apply()
    }

    fun setUserExercise(name: String, exercise: Boolean) {
        preferences.edit().putBoolean("${name}Exercise More", exercise).apply()
    }

    //function to set the user name in storage
    fun getUserProfilePass(name: String): LiveData<String> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), "")) {it[name]}

    fun getUserSleep(name: String): LiveData<Boolean> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), false)) {it[name]}

    fun getUserHealth(name: String): LiveData<Boolean> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), false)) {it[name]}

    fun getUserOrganize(name: String): LiveData<Boolean> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), false)) {it[name]}

    fun getUserQuit(name: String): LiveData<Boolean> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), false)) {it[name]}

    fun getUserExercise(name: String): LiveData<Boolean> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), false)) {it[name]}


    companion object {
        private const val PREFS = "profile"
    }
}
