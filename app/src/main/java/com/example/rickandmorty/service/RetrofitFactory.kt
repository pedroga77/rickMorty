package com.example.rickandmorty.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://rickandmortyapi.com/api/"

    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getCharacterService() : CharacterService{
        return RETROFIT_FACTORY
            .create(CharacterService::class.java)
    }

}

