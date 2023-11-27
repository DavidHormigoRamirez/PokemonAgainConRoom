package com.turing.alan.pokemonagainconroom.data.repository

import com.turing.alan.pokemonagainconroom.data.local.PokemonLocalRepository
import com.turing.alan.pokemonagainconroom.data.local.asListPokemon
import com.turing.alan.pokemonagainconroom.data.network.PokemonNetworkRepository
import com.turing.alan.pokemonagainconroom.data.network.asEntityModelList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val localRepository: PokemonLocalRepository,
    private val networkRepository: PokemonNetworkRepository
) {

    val allPokemon: Flow<List<Pokemon>>
        get() {
            return localRepository.allPokemon.map {
                listPokemonEntity ->
                    listPokemonEntity.asListPokemon()
            }
        }
    suspend fun refreshList() = withContext(Dispatchers.IO) {
        val pokemonApiModelList = networkRepository.getAll()
        localRepository.insert(pokemonApiModelList.asEntityModelList())

    }
}