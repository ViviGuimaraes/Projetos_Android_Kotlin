package com.example.controledenotas

//FORMAS DE CALCULAR A MÉDIA

//    private fun calcularMedia(nota1: Double, nota2: Double):Double{
//            return (nota1+nota2) /2
//    }
//private fun calcularMedia(nota1: Double, nota2: Double) =(nota1+nota2) /2

// val calcularMedia ={nota1: Double, nota2: Double -> (nota1+nota2) /2 }

fun calcularMedia(vararg notas: Int): Int{
    var soma = 0
    for(nota in notas){
        soma = soma + nota
    }
    return soma/notas.size
}