# Le module Fetcher

Vous allez à présent porter le module `fetcher`.

## Une fois n'est pas coutume

Indiquez au module `fetcher` que vous souhaitez utiliser les dépendances indiquées dans le POM parent.

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

## Le chemin continue

Portez l'interface `Pokeapi`.
Portez `Type` et `BattleRepository` en data class.

## FetcherApplication

Portez le fichier `FetcherApplication` en Kotlin :
- Transformez le logger en propriété privée ou en tant que `companion`
- Itérez sur le nombre de pokemon en utilisant un range
- Utilisez l'opérateur `use` pour gérer vos flux closable

## Vérification

Vérifiez que votre application fonctionne en la lançant. Il ne doit y avoir aucune erreur :pray:
