# Le module Fetcher

Vous allez à présent porter le module `fetcher`.

## On prend les mêmes et on recommence

Comme précédemment, ajouter les plugins et les dépendances nécessaire à maven pour builder du Kotlin avec Spring boot.

Renommer le dossier `src/main/java` en `src/main/kotlin`.

Porter l'interface `Pokeapi`.
Porter `Type` et `BattleRepository` en data class.

## FetcherApplication

Porter le fichier `FetcherApplication` en Kotlin:
- Transformer le logger en propriété privée ou en tant que `companion`
- Itérer sur le nombre de pokemon en utilisant un range
- Utiliser l'opérateur `use` pour gérer vos flux closable

## Vérification

Vérifier que votre application fonctionne en la lançant. Il ne doit y avoir aucune erreur :pray:
