package com.demo.finalproject.data.api

import com.demo.finalproject.domain.PokemonList
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon?limit=151")
    fun loadPokemon(): Call<PokemonList>

}