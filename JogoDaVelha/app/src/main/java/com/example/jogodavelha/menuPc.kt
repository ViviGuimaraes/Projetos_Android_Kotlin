package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class menuPc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pc)


        //capiturando o botão do LinearLayout

        val BtJogarPC = findViewById<Button>(R.id.BtJogarPC)
        val  BtMenuPC = findViewById<Button>(R.id.BtMenuPC)
        val nomeJogador1 = findViewById<EditText>(R.id.nomeJogador1)

        BtJogarPC.setOnClickListener {

            val intent = Intent(this, jogo::class.java)

            intent.putExtra("nomeJogador1", nomeJogador1.text.toString())
            intent.putExtra("nomeJogador2", " P C")
//            terminar  de colocar o nome do pc na tela do placar 



            startActivity(intent)


        }

        BtMenuPC.setOnClickListener {

            val intent = Intent(this, Telainical::class.java)

            startActivity(intent)
        }
    }
}