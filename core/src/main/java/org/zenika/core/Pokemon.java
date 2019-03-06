package org.zenika.core;

import java.util.List;

public class Pokemon {

    private Long id;

    private String name;

    private String baseExperience;

    private int height;

    private boolean isDefault;

    private int order;

    private int weight;

    public Pokemon() {
    }

    public Pokemon(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.baseExperience = pokemon.getBaseExperience();
        this.isDefault = pokemon.isDefault();
        this.height = pokemon.getHeight();
        this.weight = pokemon.getWeight();
        this.order = pokemon.getOrder();
        this.types = pokemon.getTypes();
    }

    private List<String> types;

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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
