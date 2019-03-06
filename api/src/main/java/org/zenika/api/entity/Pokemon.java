package org.zenika.api.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "pokemonName")
    private String name;

    private String baseExperience;

    private int height;

    private boolean isDefault;

    @Column(name = "POKEMON_ORDER")
    private int order;

    private int weight;

    private String types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(String baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public org.zenika.core.Pokemon toPokemon() {
        org.zenika.core.Pokemon pokemon = new org.zenika.core.Pokemon();
        pokemon.setId(this.id);
        pokemon.setName(this.name);
        pokemon.setBaseExperience(this.baseExperience);
        pokemon.setDefault(this.isDefault);
        pokemon.setHeight(this.height);
        pokemon.setWeight(this.weight);
        pokemon.setOrder(this.order);
        pokemon.setTypes(Arrays.asList(this.types.split(",")));
        return pokemon;
    }
}
