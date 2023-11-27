package com.turing.alan.pokemonagainconroom.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class],version=1)
abstract class PokemonDatabase():RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var _INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context):PokemonDatabase {
            return _INSTANCE ?: synchronized(this) {
                _INSTANCE ?: buildDatabase(context).also {
                    database -> _INSTANCE = database }
            }
        }

        private fun buildDatabase(context:Context):PokemonDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PokemonDatabase::class.java,
                "pokemon_db"
            ).build()
        }
    }


}