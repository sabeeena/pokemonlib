package com.demo.finalproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.finalproject.data.api.PokemonApiFactory
import com.demo.finalproject.R

class MainActivity : AppCompatActivity() {

    private val adapter : PokemonAdapter = PokemonAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val item = findViewById<RecyclerView>(R.id.pokemonList)

        item.layoutManager = LinearLayoutManager(this)
        PokemonApiFactory.create().loadPokemon({ pokemon ->
            adapter.setItems(pokemon)
        }, {
            println("Error")
        })

        item.adapter = adapter

    }
}