package com.demo.finalproject.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.demo.finalproject.domain.Pokemon
import com.demo.finalproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_list_item.view.*
import java.util.*

class PokemonAdapter (val activity: Activity)
        : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

        private val pokemons: MutableList<Pokemon> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
            return PokemonViewHolder(view)
        }

        override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
            val pokemon = pokemons[position]
            holder.bind(pokemon, activity)
        }

        override fun getItemCount(): Int {
            return pokemonss.size
        }

        fun setItems(items: List<Pokemon>) {
            pokemons.clear()
            pokemons.addAll(items)
            notifyDataSetChanged()
        }

        class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val name = view.tvName

            @SuppressLint("SetTextI18n")
            fun bind(pokemon: Pokemon, activity: Activity) {
                name.text = pokemon.id.toString() + ". " + pokemon.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }

                val image = itemView.findViewById<ImageView>(R.id.pokemonImage)
                Picasso.get().load(pokemon.imageUrl)
                    .placeholder(R.drawable.placeholder)
                   // .error(R.drawable.error_image)
                    .fit()
                    .centerCrop()
                    .into(image)

            }
        }

    }
