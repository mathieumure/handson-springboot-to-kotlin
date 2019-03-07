# Le module API

C'est parti, vous allez à présent porter votre premier module en Kotlin: `api`.

## Maven

Pour pouvoir compiler des fichiers Kotlin, vous aller avoir besoin d'ajouter de nouvelles dépendances à votre module maven:

- `kotlin-stdlib-jdk8` Kotlin à proprement parler mais pour les JDK > 8
- `kotlin-reflect` la bibliothèque Kotlin de réflection (obligatoire pour pouvoir utiliser Spring 5)
- `jackson-module-kotlin` pour ajouter le support de JSON des classes Kotlin

Il reste ensuite à configurer le build maven pour compiler nos fichiers `.kt` en fichier `.class`, pour cela on va avoir besoin du plugin `kotlin-maven-plugin` et on va le configurer avec:

- kotlin-maven-allopen plugin pour ouvrir les classes Spring (les classes sont finales par défaut en Kotlin)
- kotlin-maven-noarg plugin pour ajouter automatiquement les constructeurs vide pour les entités JPA


```xml
<plugin>
    <artifactId>kotlin-maven-plugin</artifactId>
    <groupId>org.jetbrains.kotlin</groupId>
    <configuration>
        <args>
            <arg>-Xjsr305=strict</arg>
        </args>
        <compilerPlugins>
            <plugin>spring</plugin>
            <plugin>jpa</plugin>
            <plugin>all-open</plugin>
        </compilerPlugins>
        <pluginOptions>
            <option>all-open:annotation=javax.persistence.Entity</option>
        </pluginOptions>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-allopen</artifactId>
            <version>${kotlin.version}</version>
        </dependency>
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-noarg</artifactId>
            <version>${kotlin.version}</version>
        </dependency>
    </dependencies>
    <executions>
        <execution>
            <id>kapt</id>
            <goals>
                <goal>kapt</goal>
            </goals>
            <configuration>
                <sourceDirs>
                    <sourceDir>src/main/kotlin</sourceDir>
                </sourceDirs>
                <annotationProcessorPaths>
                    <annotationProcessorPath>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-configuration-processor</artifactId>
                        <version>${project.parent.version}</version>
                    </annotationProcessorPath>
                </annotationProcessorPaths>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Ajouter également la configuration suivante pour basculer dans le monde Kotlin

```xml
<build>
    <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
    ...
</build>
``` 

## ApiApplication

Avant de commencer, renommer le dossier `src/main/java` en `src/main/kotlin`.

Ensuite renommer le fichier `ApiApplication.java` en `ApiApplication.kt`.

Changer la syntaxe de class Java en class Kotlin:

```kotlin
@OneAnnotation
class MyClass() {}
```
::: tip
Pensez à supprimer tout ce qui est inutile comme les point-virgules, les constructeurs vides et les block vides.
:::

::: tip
En Kotlin, le main n'est pas à mettre dans une classe.
:::

Changer la méthode main pour utiliser spring boot:

```kotlin
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
```

Kotlin compilant en class, l'interoparabilité avec Java est complète. Vérifier que votre application démarre.

## Controller

Au tour du package `controller`, renommer le fichier `PokemonsController.java` en `PokemonsController.kt`.

Réécriver ce fichier en kotlin. Ce fichier ne doit pas contenir de block de fonction, uniquement des fonctions inlines, `let` et l'opérateur elvis.

::: tip Bonus
:bulb: Utiliser une extension `wrap` pour retourner `ResponseEntity.ok(it)` si le service vous retourne un objet et `ResponseEntity.notFound().build()` sinon.
:::

## Repository & Client

Réécrire les fichiers `PokemonRepository` et `ArenaApi` en Kotlin en utilisant une interface Kotlin.

## Configuration

Réécrire le fichier `ApiClientConfiguration` en kotlin avec les contraintes suivantes:
- Pas de block de fonction, uniquement des fonctions inline
- Utiliser la référence de classe Java à partir de la [Kclass](https://kotlinlang.org/docs/reference/reflection.html#class-references) de AreneApi

## Entités

Réécrire le fichier `BattleEntity` en tant que data class Kotlin.
Pour le fichier `Pokemon` utiliser une classe Kotlin qui aura:
- un constructeur par défaut non vide
- la fonction `toPokemon` qui utilisera la fonction `apply` fournie par Kotlin

## Service

Pour finir avec ce module, il nous reste à porter `PokemonService`.

Pour cela:
- Injecter l'ensemble des dépendances dans le constructeur par défaut
- Réécrire la fonction `getAllPokemon` en fonction inline
- Réécrire la fonction `getPokemonByIdOrName` en fonction inline à l'aide d'un opérateur elvis
- Réécrire la fonction `getAllPokemonTypes` en fonction inline
- Réécrire la fonction `fight`
- Réécrire la fonction `getBattle` en fonction inline

## Vérification

Vérifier que l'ensemble de l'API fonctionne en éxécutant les commandes suivantes:

```bash
curl http://localhost:8080/pokemons
curl http://localhost:8080/pokemons/6
curl http://localhost:8080/pokemons/types
curl http://localhost:8080/pokemons/6/vs/3
curl http://localhost:8080/pokemons/battle/<ID-BATTLE>
```