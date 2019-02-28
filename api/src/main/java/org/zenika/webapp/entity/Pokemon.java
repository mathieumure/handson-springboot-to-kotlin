package org.zenika.webapp.entity;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "pokemonName")
    private String name;

    public Pokemon() {
    }

    public Pokemon(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
