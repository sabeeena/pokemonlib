package com.demo.finalproject.data.service

import com.demo.finalproject.data.api.PokemonApi
import com.demo.finalproject.domain.Pokemon
import com.demo.finalproject.domain.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonService (
        private val pokemonApi: PokemonApi
    ) {

    fun loadPokemon(success: (pokemonList: List<Pokemon>) -> Unit, failure: () -> Unit) {
        pokemonApi.loadPokemon().enqueue(object: Callback<PokemonList> {

            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                success(response.body()?.results ?: listOf())
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                failure()
            }

        })

    }
}