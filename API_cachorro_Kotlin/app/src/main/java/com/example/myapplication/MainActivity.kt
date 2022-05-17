 package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InlineSuggestionsResponse
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.myapplication.classendopoint.Endpoint
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPesquisar.setOnClickListener { getImage() }

    }
     private  fun getImage(){


         val url ="https://dog.ceo/"
         val retrofitClient = retrofitInstance(url)
         val endpoint = retrofitClient.create(Endpoint::class.java)
         val raca = binding.editRaca.text.toString()

         endpoint.getDog(raca).enqueue(object : Callback<JsonObject>{
             override fun onResponse(call:  Call<JsonObject>, response: Response<JsonObject>){
                 val urlImage= response.body()?.get("message")?.asString
                 Picasso.get().load(urlImage).into(binding.imageApi)
             }
             override fun onFailure(call: Call<JsonObject>, t: Throwable){
                 Toast.makeText(applicationContext, "Erro ao acessar", Toast.LENGTH_LONG)
             }
         })


     }

     private fun retrofitInstance(url: String): Retrofit{
         return  Retrofit
             .Builder()
             .baseUrl(url)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

     }
 }