package com.turing.alan.pokemonagainconroom.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turing.alan.pokemonagainconroom.data.repository.Pokemon
import com.turing.alan.pokemonagainconroom.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    private val _pokemonList: MutableStateFlow<List<Pokemon>>
        = MutableStateFlow(listOf())
    val pokemonList: StateFlow<List<Pokemon>>
        get() = _pokemonList.asStateFlow()

    init {

        viewModelScope.launch {
            try {
                repository.refreshList()
            }
            catch (e:IOException) {
                // TODO Manejar el error
            }
        }
        viewModelScope.launch {
            repository.allPokemon.collect {
                _pokemonList.value = it
            }
        }
    }
}