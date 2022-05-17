package com.example.calculo_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RelatorioActivy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorio_activy)

        val alturaTextView =findViewById<TextView>(R.id.altura)
        val pesoTextView =findViewById<TextView>(R.id.peso)
        val resultadoTextView =findViewById<TextView>(R.id.situacao)
        val calculandoIMCTextView =findViewById<TextView>(R.id.imc)


        val intent: Intent = getIntent()


        alturaTextView.text =intent.getStringExtra("altura")
        pesoTextView.text =intent.getStringExtra("peso")
        resultadoTextView.text =intent.getStringExtra("resultado")
        calculandoIMCTextView.text =intent.getStringExtra("calculandoIMC")
    }
}