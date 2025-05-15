package com.example.rickandmorty.service

import com.example.rickandmorty.model.Result
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    fun listALL(): Call<Result>

}