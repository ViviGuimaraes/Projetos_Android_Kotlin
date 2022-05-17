package com.example.calculo_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat


//foi declarada fora para poder ser usada fora da função calculo
// o comando lateunit var  é para declarar depois dos comandos

private lateinit var alturaEditText :EditText
private lateinit var pesoEditText :EditText



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Colocando ação no botão
        val calcular = findViewById<Button>(R.id.calcular) as Button
        val fechar = findViewById<Button>(R.id.fechar)


        calcular.setOnClickListener {

            alturaEditText = findViewById(R.id.altura)
           pesoEditText = findViewById(R.id.peso)


            val resultado = findViewById<TextView>(R.id.resultado)
            var situacao = " "


            //declarando o conteúdo da caixa de texto
            val altura = alturaEditText.text.toString().toDouble()
            val peso = pesoEditText.text.toString().toDouble()

            //formatção para colocar duas ou mais casas após a virgula,
            val dec = DecimalFormat("#.00")

            val calculandoIMC =  peso/(altura * altura)

            if (calculandoIMC<18.5)
                situacao = " Está Abaixo do peso! Cuidado "

            else if(calculandoIMC<24.9)
                situacao ="Está no peso ideal ! Parabéns"

            else if(calculandoIMC<29.9)
                situacao= "Sobrepeso! Cuidado "

            else if(calculandoIMC<34.9)
                situacao= "Está com Obesidade grau I! Cuidado "

            else if(calculandoIMC<39.9)
                situacao= "Está com Obesidade grau II! (Morbida) Cuidado "

            else if(calculandoIMC>40)
                situacao= "Está com Obesidade grau III! (Severa) Cuidado "



        val intent =Intent(this,RelatorioActivy::class.java)


        intent.putExtra("altura",altura.toString())
            intent.putExtra("peso","${peso}")
            intent.putExtra("resultado",situacao)
            intent.putExtra("calculandoIMC",dec.format(calculandoIMC))

            startActivity(intent)


        }
        //Colocando a ação de sair no botão fechar.
        fechar.setOnClickListener {
            finish()
        }
    }
}

private fun validarCampus(): Boolean {
    var noErro = true


    if(alturaEditText.text.isBlank()){
        alturaEditText.setError("Altura:")
        noErro = false
    }
    if(pesoEditText.text.isBlank()){
        pesoEditText.setError("Peso:")
        noErro = false
    }
    return noErro
}