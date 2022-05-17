package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class menujogador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menujogador)

        //capiturando o botão do LinearLayout

        val BtJogar = findViewById<Button>(R.id.BtJogar)
        val BtMenu = findViewById<Button>(R.id.BtMenu)
        val nomeJogador1 = findViewById<EditText>(R.id.nomeJogador1)
        val nomeJogador2 = findViewById<EditText>(R.id.nomeJogador2)


        BtJogar.setOnClickListener {

            val intent = Intent(this, jogo::class.java)

            intent.putExtra("nomeJogador1", nomeJogador1.text.toString())
            intent.putExtra("nomeJogador2", nomeJogador2.text.toString())

            startActivity(intent)

        }

        BtMenu.setOnClickListener {

            val intent = Intent(this, Telainical::class.java)

            startActivity(intent)
        }
    }
}