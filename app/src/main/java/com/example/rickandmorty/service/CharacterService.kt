package com.example.rickandmorty.service

import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    fun listALL(): Call<Result>


    @GET("character/{id}")
    fun findById(@Path("id")id: Int): Call<Character>
}