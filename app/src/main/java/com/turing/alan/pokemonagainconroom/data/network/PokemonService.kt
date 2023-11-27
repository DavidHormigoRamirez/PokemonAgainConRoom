package com.turing.alan.pokemonagainconroom.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

interface PokemonApi {
    @GET("pokemon")
    suspend fun getAll():PokemonListResponse
    @GET("pokemon/{name}")
    suspend fun getDetail(@Path("name") name:String):PokemonDetailResponse
}

@Singleton
class PokemonService @Inject constructor () {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api:PokemonApi = retrofit.create(PokemonApi::class.java)
}