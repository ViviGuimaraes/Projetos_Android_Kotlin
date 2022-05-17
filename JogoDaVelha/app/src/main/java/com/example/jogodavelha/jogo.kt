package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class jogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)


        val BtPlacar = findViewById<Button>(R.id.BtPlacar)

        val BtNvJogo = findViewById<Button>(R.id.BtNvJogo)

        val BtMenuJogo = findViewById<Button>(R.id.BtMenuJogo)

        val nomeJogador1 = findViewById<TextView>(R.id.nome1)
        val nomeJogador2 = findViewById<TextView>(R.id.nome2)

        val intent:Intent = getIntent()

        nomeJogador1.text = intent.getStringExtra("nomeJogador1")
        nomeJogador2.text = intent.getStringExtra("nomeJogador2")


        BtPlacar.setOnClickListener {

            val intent = Intent(this, Placar::class.java)

            intent.putExtra("nomeJogador1", nomeJogador1.text.toString())
            intent.putExtra("nomeJogador2", nomeJogador2.text.toString())

            startActivity(intent)


        }

        BtNvJogo.setOnClickListener {

            val intent = Intent(this, jogo::class.java)

            intent.putExtra("nomeJogador1", nomeJogador1.text.toString())
            intent.putExtra("nomeJogador2", nomeJogador2.text.toString())

            startActivity(intent)


        }


        BtMenuJogo.setOnClickListener {

            val intent = Intent(this, Telainical::class.java)

            startActivity(intent)


        }


//        função para capiturar a ação do botão

        fun btnClick(view: View){

            val btnClicado = view as Button

            var cellID = 0

            when(btnClicado.id)
            {
               R.id.b1-> cellID = 1
                R.id.b2-> cellID = 2
                R.id.b3-> cellID = 3
                R.id.b4-> cellID = 4
                R.id.b5-> cellID = 5
                R.id.b6-> cellID = 6
                R.id.b7-> cellID = 7
                R.id.b8-> cellID = 8
                R.id.b9-> cellID = 9


            }


        }

    }


}