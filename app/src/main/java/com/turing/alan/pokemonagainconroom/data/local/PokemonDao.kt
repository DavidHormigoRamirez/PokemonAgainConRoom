package com.turing.alan.pokemonagainconroom.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPokemon(listPokemonEntity: List<PokemonEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPokemon(pokemonEntity: PokemonEntity)
    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): Flow<List<PokemonEntity>>
}