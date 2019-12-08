package com.example.activeu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activeu.R
//import com.example.activeu.viewmodel.CountViewModel
//import com.example.activeu.viewmodel.GifViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.atomic.LongAdder
import java.util.*

class MainActivity : AppCompatActivity() {

    private fun getUserName() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
