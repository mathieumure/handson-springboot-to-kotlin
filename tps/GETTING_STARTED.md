# Getting Started

Dans cet atelier, vous allez migrer un application existante, codée en Java, en une application codée en Kotlin.

L'application de base est une application maven, composée de plusieurs modules :

- `core` : le module contenant les entités et les utilitaires métiers
- `fetcher` : un module **Spring boot** de type console qui permet de récupérer les données depuis la [pokeapi](https://pokeapi.co/) et de générer un fichier de script sql
- `api` : un module **Spring boot** web avec une base de donnée JPA qui expose une API qui permet de lister les pokemons et de les faire s'affronter. L'affrontement est réalisé par un autre module
- `arena` : un module **Spring boot** web avec une base de donnée Mongo qui expose une API qui permet de faire s'affronter les Pokemon tour par tour lors d'un batch


## Récupération du projet

Pour bien démarrer, assurez-vous d'avoir les outils suivant d'installés :

- [Git](https://git-scm.com/)
- [JDK 8 ou supérieur](https://www.java.com/fr/download/)
- [Maven](https://maven.apache.org/download.cgi)
- Votre IDE préféré


Ensuite téléchargez le projet depuis github :

```bash
git clone https://github.com/mathieumure/handson-springboot-to-kotlin.git
```

## Lancement du projet

Ouvrez le projet dans votre IDE et assurez-vous que celui-ci build :

```bash
mvn clean install
```

et que le module `api` démarre :

```bash
cd api/
mvn spring-boot:run
```

ainsi que le module `arena` :

```bash
cd arena/
mvn spring-boot:run
```

Récupérez la liste des pokemons :

```bash
curl http://localhost:8080/pokemons
```

Lancez un combat :

```bash
curl http://localhost:8080/pokemons/3/vs/6
```

et vérifiez le statut de celui-ci :

```bash
curl http://localhost:8080/pokemons/battle/<THE ID RETURNED PREVIOUSLY>
```