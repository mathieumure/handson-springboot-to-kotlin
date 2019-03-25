# Le module Arena

Vous allez à présent porter le module `arena`.

## On prend les mêmes et on recommence

Indiquez au module `arena` que vous souhaitez utiliser les dépendances indiquées dans le POM parent.

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

# Premièrement

Portez les fichiers `ArenaApplication`, `FightController`, `BattleRepository`, `ArenaService` et `BattleEntity` en Kotlin en utilisant au maximum des fonctions Single-Expression.

## FightRunner

Porter le fichier `FightRunner` en Kotlin :
- Transformez le logger en propriété privée ou en tant que `companion`
- Utilisez l'opérateur `when` pour supprimer les `if`

## Vérification

Vérifiez que l'ensemble de l'API fonctionne en exécutant les commandes suivantes :

```bash
curl http://localhost:8080/pokemons
curl http://localhost:8080/pokemons/6
curl http://localhost:8080/pokemons/types
curl http://localhost:8080/pokemons/6/vs/3
curl http://localhost:8080/pokemons/battle/<ID-BATTLE>
```