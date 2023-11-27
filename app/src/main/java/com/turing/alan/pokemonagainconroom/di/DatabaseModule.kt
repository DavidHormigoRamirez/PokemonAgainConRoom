package com.turing.alan.pokemonagainconroom.di

import android.content.Context
import com.turing.alan.pokemonagainconroom.data.local.PokemonDao
import com.turing.alan.pokemonagainconroom.data.local.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):PokemonDatabase {
        return PokemonDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providePokemonDao(database: PokemonDatabase): PokemonDao {
        return database.pokemonDao()
    }

}