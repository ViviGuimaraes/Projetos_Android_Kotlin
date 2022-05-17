package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Telainical : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telainicial)

        //capiturando o botão do LinearLayout

        val BtJogador = findViewById<Button>(R.id.BtJogador) as Button
        val  BtPC = findViewById<Button>(R.id.BtPC)

        BtJogador.setOnClickListener {

            val intent = Intent(this, menujogador::class.java)

            startActivity(intent)


        }

        BtPC.setOnClickListener {

            val intent = Intent(this, menuPc::class.java)

            startActivity(intent)


        }
    }
}