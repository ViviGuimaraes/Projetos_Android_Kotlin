package com.example.manipulandoviws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.manipulandoviws.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //variável para receber a activity
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Atribuir a activiry a variavel criada (binding)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Ultilizando referência para a activiry por meio do binding
        setContentView(binding.root)

        val  toastButton = findViewById<Button>(R.id.toast)
        toastButton.setOnClickListener { mensagemToast() }


        alert.setOnClickListener { mensagemAlert() }

    binding.snack.setOnClickListener { mensagemSnack() }


    }

    private fun mensagemSnack() {
        val snackButton = findViewById<Button>(R.id.snack)
        Snackbar.make(snackButton, "Mensagem usando o snack", Snackbar.LENGTH_INDEFINITE)
            .setAction("Sair"){finish()}
            .show()
    }

    private fun mensagemAlert() {
        AlertDialog
            .Builder(this)
            .setTitle("Atenção ." )
            .setMessage("Deseja sair do App ?")
            .setPositiveButton("sim"){_,_->finish()}
            .setNegativeButton("Não"){_,_->}
            .show()
    }

    private fun mensagemToast(){


        Toast.makeText(this, "oi, mensagem text", Toast.LENGTH_LONG).show()
    }
}