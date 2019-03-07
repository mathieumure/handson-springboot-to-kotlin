# Getting Started

Dans cet atelier, vous allez migrer un application existante, codée en Java, en une application codée en Kotlin.

L'application de base est une application maven, composée de plusieurs modules:

- `core`: le module contenant les entités et les utilitaires métiers
- `fetcher`: un module **Spring boot** de type console qui permet de récupérer les données depuis la [pokeapi](https://pokeapi.co/) et de générer un fichier de script sql
- `api`: un module **Spring boot** web avec une base de donnée JPA qui expose une API qui permet de lister les pokemons et de les faire s'affronter. L'affrontement est réalisé par un autre module
- `arena`: un module **Spring boot** web avec une base de donnée Mongo qui expose une API qui permet de faire s'affronter les Pokemon tour par tour lors d'un batch


## Récupération du projet

Pour bien démarrer, assurez-vous d'avoir les outils suivant d'installés:

- [Git](https://git-scm.com/)
- [JDK 8 ou supérieur](https://www.java.com/fr/download/)
- [Maven](https://maven.apache.org/download.cgi)
- Votre IDE préféré


Ensuite télécharger le projet depuis github:

```bash
git clone https://github.com/mathieumure/handson-springboot-to-kotlin.git
```

## Lancement du projet

Ouvrer le projet dans votre IDE et assurez-vous que celui-ci fonctionne en lançant les modules `api` et `core`.

Récupérer la liste des pokemons:

```bash
curl http://localhost:8080/pokemons
```

Lancer un combat:

```bash
curl http://localhost:8080/pokemons/fight/3/vs/6
```

et vérifier le statut de celui-ci:

```bash
curl http://localhost:8080/pokemons/battle/<THE ID RETURNED PREVIOUSLY>
```