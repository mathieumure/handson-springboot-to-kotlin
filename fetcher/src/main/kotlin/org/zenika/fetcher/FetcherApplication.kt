package org.zenika.fetcher

import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.zenika.core.Pokemon

import java.io.FileWriter
import java.io.PrintWriter

const val NB_POKEMONS = 721
const val SQL_FILENAME = "api/src/main/resources/data.sql"

@SpringBootApplication
class FetcherApplication: CommandLineRunner {
    private val LOGGER: Logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        val pokeapi = Feign.builder()
                .encoder(JacksonEncoder())
                .decoder(JacksonDecoder())
                .target(Pokeapi::class.java, "https://pokeapi.co/")

        val pokemonsData = mutableListOf<PokemonData>()

        for (i in 1..NB_POKEMONS) {
            LOGGER.info("Fetching pokemon $i...")
            val pokemon = pokeapi.get(i)
            LOGGER.info("${pokemon.name} is founded")
            pokemonsData.add(pokemon)
        }

        val pokemons = pokemonsData.map {
            Pokemon().apply {
                id = it.id
                name = it.name
                baseExperience = it.baseExperience
                height = it.height
                isDefault = it.isDefault
                order = it.order
                weight = it.weight
                types = it.types.mapNotNull { type -> type.type["name"] }
            }
        }

        LOGGER.info("${pokemons.size} pokemons found")
        LOGGER.info("writing to file ")
        PrintWriter(FileWriter(SQL_FILENAME)).use {
            it.println("INSERT INTO POKEMON (ID, POKEMON_NAME, BASE_EXPERIENCE, HEIGHT, IS_DEFAULT, POKEMON_ORDER, WEIGHT, TYPES) values")

            val iterator = pokemons.iterator()
            while (iterator.hasNext()) {
                val pokemon = iterator.next()
                it.printf(
                        "(%s, '%s', %s, %s, %s, %s, %s, '%s')",
                        pokemon.id, pokemon.name, pokemon.baseExperience,
                        pokemon.height, pokemon.isDefault, pokemon.order,
                        pokemon.weight, pokemon.types.joinToString(","))
                if (iterator.hasNext()) {
                    it.println(",")
                } else {
                    it.println("")
                }
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<FetcherApplication>(*args)
}