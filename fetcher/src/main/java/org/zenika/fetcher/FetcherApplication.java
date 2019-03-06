package org.zenika.fetcher;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zenika.core.Pokemon;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FetcherApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetcherApplication.class);

    public static final int NB_POKEMONS = 721;
    public static final String SQL_FILENAME = "api/src/main/resources/data.sql";

    public static void main(String[] args) {
        SpringApplication.run(FetcherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Pokeapi pokeapi = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(Pokeapi.class, "https://pokeapi.co/");

        List<PokemonData> pokemonsData = new ArrayList<>();

        for (int i = 1; i<= NB_POKEMONS; i++) {
            LOGGER.info("Fetching pokemon " + i + "...");
            PokemonData pokemon = pokeapi.get(i);
            LOGGER.info(pokemon.getName() + " is founded");
            pokemonsData.add(pokemon);
        }

        List<Pokemon> pokemons = pokemonsData.stream().map(pokemonData -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(pokemonData.getId());
            pokemon.setName(pokemonData.getName());
            pokemon.setBaseExperience(pokemonData.getBaseExperience());
            pokemon.setHeight(pokemonData.getHeight());
            pokemon.setDefault(pokemonData.isDefault());
            pokemon.setOrder(pokemonData.getOrder());
            pokemon.setWeight(pokemonData.getWeight());
            pokemon.setTypes(pokemonData.getTypes().stream().map(type -> type.getType().get("name")).collect(Collectors.toList()));
            return pokemon;
        }).collect(Collectors.toList());

        LOGGER.info(pokemons.size() + " pokemons found");
        LOGGER.info("writing to file ");
        FileWriter fileWriter = new FileWriter(SQL_FILENAME);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("INSERT INTO POKEMON (ID, POKEMON_NAME, BASE_EXPERIENCE, HEIGHT, IS_DEFAULT, POKEMON_ORDER, WEIGHT, TYPES) values");

        Iterator<Pokemon> iterator = pokemons.iterator();
        while (iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            printWriter.printf(
                    "(%s, '%s', %s, %s, %s, %s, %s, '%s')",
                    pokemon.getId(), pokemon.getName(), pokemon.getBaseExperience(),
                    pokemon.getHeight(), pokemon.isDefault(), pokemon.getOrder(),
                    pokemon.getWeight(), String.join(",", pokemon.getTypes())
            );
            if (iterator.hasNext()) {
                printWriter.println(",");
            } else {
                printWriter.println(";");
            }
        }
        printWriter.close();

    }
}
