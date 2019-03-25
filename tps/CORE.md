# Le module Core

## On ne vous explique plus par où commencer

Le module `core` n'est pas un module lié à Spring boot mais nous avons quand même besoin de configurer maven.

Indiquez à ce module que vous souhaitez encore une fois utiliser les dépendances indiquées dans le POM parent.

```xml
<project>
    <dependencies>
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-stdlib-jdk8</artifactId>
        </dependency>
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-reflect</artifactId>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.module</groupId>
            <artifactId>jackson-module-kotlin</artifactId>
        </dependency>
    </dependencies>
</project>
```

et ajoutez le plugin configuré dans le parent

```xml
<build>
    <plugins>
        ...
        <plugin>
            <artifactId>kotlin-maven-plugin</artifactId>
            <groupId>org.jetbrains.kotlin</groupId>
        </plugin>
    </plugins>
</build>
```

## enum

Portez `BattleStatus` et `PokemonType` en enum Kotlin.

## Pokemon

Portez `Pokemon` en classe ouverte à l'héritage. Cette classe doit posséder un constructeur par défaut avec une liste de champs tous optionnels.

Ajoutez un second constructeur qui prend un Pokemon en paramètre et utilisera la fonction `apply` pour mettre à jour ses propriétés.

## FightingPokemon

Transformez la classe `FightingPokemon` en Kotlin. Cette classe n'a pas besoin de constructeur par défaut.

Transformez `isKO` en propriété en lecture seule grâce au mot clé `get`.

## Battle

Transformez la class `Battle` en Kotlin. Cette classe doit être ouverte et ne doit pas avoir de constructeur par défaut.

Transformez les méthodes `getStarter()`, `getEnder()` et `getBattleStatus()` en propriété en lecture seule.

## FightService

FightService est une classe utilitaire, qui n'a que des méthodes statiques. Transformez donc ce fichier en `object`.

## PokemonUtils

Pour finir, si vous en avez le courage, transformez la classe utilitaire `PokemonUtils` en Kotlin.

Si vous n'avez pas le courage, utilisez `CTRL + ALT + SHIFT + K` pour demander à IntelliJ de le faire pour vous.