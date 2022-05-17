package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Placar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)



        val BtMenuPlacar = findViewById<Button>(R.id.BtMenuPlacar) as Button

        val BtNvJogoPlacar = findViewById<Button>(R.id.BtNvJogoPlacar) as Button

        val placarnome1 = findViewById<TextView>(R.id.nome1)
        val placarnome2= findViewById<TextView>(R.id.nome2)

        val nomeJogador1 = findViewById<TextView>(R.id.nome1)
        val nomeJogador2 = findViewById<TextView>(R.id.nome2)

        val intent:Intent = getIntent()

        placarnome1.text = intent.getStringExtra("nomeJogador1")
        placarnome2.text = intent.getStringExtra("nomeJogador2")



        BtMenuPlacar.setOnClickListener {

            val intent = Intent(this, Telainical::class.java)



            startActivity(intent)


        }


        BtNvJogoPlacar.setOnClickListener {

            val intent = Intent(this, jogo::class.java)

            intent.putExtra("nomeJogador1", nomeJogador1.text.toString())
            intent.putExtra("nomeJogador2", nomeJogador2.text.toString())

            startActivity(intent)


        }

    }
}