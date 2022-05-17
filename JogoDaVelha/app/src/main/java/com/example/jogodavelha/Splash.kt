package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




            Timer().schedule(2000) { abriMain() }
        }

        private fun abriMain() {
            val intent = Intent(this, Telainical::class.java)
            startActivity(intent)
            finish()
        }
    }
