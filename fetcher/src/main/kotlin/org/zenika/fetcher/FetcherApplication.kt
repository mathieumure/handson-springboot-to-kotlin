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
            val pokemon = Pokemon()
            pokemon.id = it.id
            pokemon.name = it.name
            pokemon.baseExperience = it.baseExperience
            pokemon.height = it.height
            pokemon.isDefault = it.isDefault
            pokemon.order = it.order
            pokemon.weight = it.weight
            pokemon.types = it.types.map { type -> type.type["name"] }
            pokemon
        }

        LOGGER.info("${pokemons.size} pokemons found")
        LOGGER.info("writing to file ")
        val fileWriter = FileWriter(SQL_FILENAME)
        val printWriter = PrintWriter(fileWriter)
        printWriter.println("INSERT INTO POKEMON (ID, POKEMON_NAME, BASE_EXPERIENCE, HEIGHT, IS_DEFAULT, POKEMON_ORDER, WEIGHT, TYPES) values")

        val iterator = pokemons.iterator()
        while (iterator.hasNext()) {
            val pokemon = iterator.next()
            printWriter.printf(
                    "(%s, '%s', %s, %s, %s, %s, %s, '%s')",
                    pokemon.id, pokemon.name, pokemon.baseExperience,
                    pokemon.height, pokemon.isDefault, pokemon.order,
                    pokemon.weight, pokemon.types.joinToString(","))
            if (iterator.hasNext()) {
                printWriter.println(",")
            } else {
                printWriter.println("")
            }
        }
        printWriter.close()
    }

}

fun main(args: Array<String>) {
    runApplication<FetcherApplication>(*args)
}