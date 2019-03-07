# Le module Arena

Vous allez à présent porter le module `arena`.

## On prend les mêmes et on recommence

Comme précédemment, ajouter les plugins et les dépendances nécessaires à maven pour builder du Kotlin avec Spring boot.

Renommer le dossier `src/main/java` en `src/main/kotlin`.

Porter les fichiers `ArenaApplication`, `FightController`, `BattleRepository`, `ArenaService` et `BattleEntity` en Kotlin en utilisant au maximum des fonctions inlines.

## FightRunner

Porter le fichier `FightRunner` en Kotlin:
- Transformer le logger en propriété privée ou en tant que `companion`
- Utiliser l'opérateur `when` pour supprimer les `if

## Vérification

Vérifier que l'ensemble de l'API fonctionne en exécutant les commandes suivantes:

```bash
curl http://localhost:8080/pokemons
curl http://localhost:8080/pokemons/6
curl http://localhost:8080/pokemons/types
curl http://localhost:8080/pokemons/6/vs/3
curl http://localhost:8080/pokemons/battle/<ID-BATTLE>
```