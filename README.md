# Hands on Spring boot to kotlin

in this handson you will start from a maven spring boot application written in java and step by step, you will migrate to a kotlin application 

## TODO

- [ ] Soluce
    - [ ] scaffold java app
    - [ ] tests
    - [ ] API => common, web, batch, utils -> extensions, jpa 
    - [ ] split in several package
- [ ] write TP in a vue-press app


# Exercice 1 - refactor core

Ajouter les plugins kotlin-maven-plugin, kotlin-maven-noarg et  kotlin-maven-allopen

Ajouter les dependances kotlin-stdlib-jdk8 et kotlin-test

Transformer la class java Pokemon en class kotlin.
Ajouter un constructeur qui prend un pokemon en paramètre
puis transformer fighting pokemon en class

PokemonType
Battle
B





- api

Importer les plugins et artifact maven
Renommer ApiApplication en class kotlin
Puis PokemonsController
PokemonREpostory
PokemonService
ArenaApi
ApiClientConfiguration

BattleEntity
Pokemon

La ça doit failed car par de constructeur par défaut -> kotlin-noard


- batch

Importer plugin et dependencies
controller
batch
repository
service
entity