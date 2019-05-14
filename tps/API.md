# Le module API

C'est parti, vous allez à présent porter votre premier module en Kotlin : `api`.

## Maven

Indiquez au module `api` que vous souhaitez utiliser les dépendances indiquées dans le POM parent.

```xml
<project>
    <dependencies>
        ...
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

## ApiApplication

Commencez par le plus petit fichier : renommer le fichier `ApiApplication.java` en `ApiApplication.kt`.

Changer la syntaxe de class Java en class Kotlin :

```kotlin
@OneAnnotation
class MyClass()
```
::: tip
Pensez à supprimer tout ce qui est inutile comme les point-virgules, les constructeurs vides et les block vides.
:::

::: tip
En Kotlin, le main n'est pas à mettre dans une classe.
:::

Changer la méthode main pour utiliser spring boot :

```kotlin
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
```

Kotlin compilant en class, l'interoparabilité avec Java est complète. Vérifier que votre application démarre.

## Controller

Au tour du package `controller`, renommer le fichier `PokemonsController.java` en `PokemonsController.kt`.

Réécriver ce fichier en kotlin. Ce fichier ne doit pas contenir de block de fonction, uniquement des fonctions Single-Expression, `let` et l'opérateur elvis.

::: tip Single-Expression functions
En kotlin il est courant d'avoir des fonctions sans body. Par exemple :
```kotlin
fun provideSomething(): Something {
  return Toto.makeIt()
}
```

Va plutôt s'écrire en une seule ligne
```kotlin
fun provideSomething() = Toto.makeIt()
```
:::

::: tip Bonus
:bulb: Utiliser une extension `wrap` pour retourner `ResponseEntity.ok(it)` si le service vous retourne un objet et `ResponseEntity.notFound().build()` sinon.
:::

## Repository & Client

Réécrire les fichiers `PokemonRepository` et `ArenaApi` en Kotlin en utilisant une interface Kotlin.

## Configuration

Réécrire le fichier `ApiClientConfiguration` en kotlin avec les contraintes suivantes :
- Pas de block de fonction, uniquement des fonctions Single-Expression
- Utiliser la référence de classe Java à partir de la [Kclass](https://kotlinlang.org/docs/reference/reflection.html#class-references) de AreneApi

## Entités

Réécrire le fichier `BattleEntity` en tant que data class Kotlin.
Pour le fichier `Pokemon` utiliser une classe Kotlin qui aura :
- un constructeur par défaut non vide
- la fonction `toPokemon` qui utilisera la fonction `apply` fournie par Kotlin

## Service

Pour finir avec ce module, il nous reste à porter `PokemonService`.

Pour cela :
- Injecter l'ensemble des dépendances dans le constructeur par défaut
- Réécrire la fonction `getAllPokemon` en fonction Single-Expression
- Réécrire la fonction `getPokemonByIdOrName` en fonction Single-Expression à l'aide d'un opérateur elvis
- Réécrire la fonction `getAllPokemonTypes` en fonction Single-Expression
- Réécrire la fonction `fight`
- Réécrire la fonction `getBattle` en fonction Single-Expression

## Vérification

Vérifier que l'ensemble de l'API fonctionne en lançant un combat depuis [http://localhost:8080](http://localhost:8080).