package com.turing.alan.pokemonagainconroom.data.network

import com.google.gson.annotations.SerializedName
import com.turing.alan.pokemonagainconroom.data.local.PokemonEntity


data class PokemonApiModel(
    val name:String,
    val id:Int,
    val frontDefault:String,
    val weight:Int,
    val height:Int
)

fun List<PokemonApiModel>.asEntityModelList():List<PokemonEntity> {
    return this.map {
        PokemonEntity(
            it.name,
            it.id,
            it.weight,
            it.height,
            it.frontDefault
        )
    }

}
data class PokemonDetailResponse(
    val name:String,
    val id:Int,
    val sprites: PokemonSpritesResponse,
    val weight:Int,
    val height:Int
) {
    fun asApiModel():PokemonApiModel {
        return PokemonApiModel(
            name,
            id,
            sprites.frontDefault,
            weight,
            height
        )
    }
}


data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val frontDefault:String
)

data  class PokemonListResponse(
    val results: List<PokemonListItemResponse>
)
data class PokemonListItemResponse(
    val name:String
)

