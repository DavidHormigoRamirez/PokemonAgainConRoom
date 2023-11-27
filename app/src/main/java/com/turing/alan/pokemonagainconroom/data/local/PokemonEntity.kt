package com.turing.alan.pokemonagainconroom.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.turing.alan.pokemonagainconroom.data.repository.Pokemon

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val name: String,
    val id: Int?,
    val weight: Int?,
    val height: Int?,
    val frontImageUrl:String?,

)

fun List<PokemonEntity>.asListPokemon():List<Pokemon> {
    return this.map {
        Pokemon(it.name,it.frontImageUrl)
    }
}
