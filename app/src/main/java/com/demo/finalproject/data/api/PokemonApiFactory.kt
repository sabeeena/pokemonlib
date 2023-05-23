package com.demo.finalproject.data.api

import com.demo.finalproject.data.service.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonApiFactory private constructor() {
    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        fun create(): PokemonService {
            val pokemonApi = PokemonService(
                getInstance().create(PokemonApi::class.java)
            )
            return pokemonApi
        }
    }
}