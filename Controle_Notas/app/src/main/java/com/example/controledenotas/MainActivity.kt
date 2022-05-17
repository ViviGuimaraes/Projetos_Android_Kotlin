package com.example.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Intent

//foi declarada fora para poder ser usada fora da função calculo
// o comando lateunit var  é para declarar depois dos comandos

private lateinit var nomeEditText :EditText
private lateinit var nota1EditText :EditText
private lateinit var nota2EditText :EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*Forma de puxar o botão do LinearLayout*/
        val calcular = findViewById<Button>(R.id.calcular) as Button
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener {

            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

         /*   val faltasEditText = findViewById<EditText>(R.id.faltas)*/
            val resultado = findViewById<TextView>(R.id.resultado)
            val relatorio = findViewById<TextView>(R.id.relatorio)




            if (validarCampus()) {

                //declarando o conteúdo da caixa de texto
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()



                val media = calcularMedia(nota1,nota2)

                val intent = Intent(this, RelatorioActivity::class.java)



                var situacao = ""

                if (media >= 5) {
                    /*resultado.text = " Nota 1 = $nota1 Nota 2 = $nota2 "
                resultado.text = "A média é =  ${media} "*/

                    situacao = " APROVADO "
                    /*resultado.setTextColor(Color.BLUE)*/

                } else {
                    situacao = " REPROVADO "
              /*      resultado.setTextColor(Color.RED)*/
                }

                intent.putExtra("nome", nomeEditText.text.toString())
                intent.putExtra("nota1", "${nota1}")
                intent.putExtra("nota2", "${nota2}")
                intent.putExtra("media", "${media}")
                intent.putExtra("situacao", "${situacao}")


                startActivity(intent)

                /*relatorio.text =
                    "Relatório:\n ${nomeEditText.text}  \nNota 1: $nota1 \nNota 2: $nota2 \nFaltas: ${faltasEditText.text} \nA média é:  ${media}  "*/
            }

            sair.setOnClickListener {
                finish()
            }
        }
    }

    private fun validarCampus(): Boolean {
        var noErro = true

        if(nomeEditText.text.isBlank()){
            nomeEditText.setError("Digite seu nome!")
            noErro = false
        }
        if(nota1EditText.text.isBlank()){
            nota1EditText.setError(" Digite a 1° nota !")
            noErro = false
        }
        if(nota2EditText.text.isBlank()){
            nota2EditText.setError("Digite a 2° nota ! ")
            noErro = false
        }
        return noErro
    }
}