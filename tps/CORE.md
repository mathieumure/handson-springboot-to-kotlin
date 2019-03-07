# Le module Core

Le module `core` n'est pas un module lié à Spring boot mais nous avons quand même besoin de configurer maven.

Ajouter les dépendances et plugins nécessaires.

## enum

Porter `BattleStatus` et `PokemonType` en enum Kotlin.

## Pokemon

Porter `Pokemon` en classe ouverte à l'héritage. Cette classe doit posséder un constructeur par défaut avec une liste de champs tous optionnels.

Ajouter un second constructeur qui prend un Pokemon en paramètre et utilisera la fonction `apply` pour mettre à jour ses propriétés.

## FightingPokemon

Transformer la classe `FightingPokemon` en Kotlin. Cette classe n'a pas besoin de constructeur par défaut.

Transformer `isKO` en propriété en lecture seule grâce au mot clé `get`.

## Battle

Transformer la class `Battle` en Kotlin. Cette classe doit être ouverte et ne doit pas avoir de constructeur par défaut.

Transformer les méthodes `getStarter()`, `getEnder()` et `getBattleStatus()` en propriété en lecture seule.

## FightService

FightService est une classe utilitaire, qui n'a que des méthodes statiques. Transformer donc ce fichier en `object`.

## PokemonUtils

Pour finir, si vous en avez le courage, transformer la classe utilitaire `PokemonUtils` en Kotlin.