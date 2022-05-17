package com.example.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        Timer().schedule(3000){
            chamarTelaMain()
        }
    }

    private fun chamarTelaMain() {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
    }
}