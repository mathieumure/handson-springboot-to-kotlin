# Configurer Kotlin

## Configuration globale

L'application est actuellement configurée pour compiler uniquement du Java, indiquez à Maven qu'il doit également prendre Kotlin en compte.

Pour indiquer à Maven de compiler nos fichiers `.kt` en `.class`, nous avons besoin du plugin `kotlin-maven-plugin` et avec 2 dépendances :

- **kotlin-maven-allopen plugin** pour rendre les classes Spring "ouvertes" (les classes sont finales par défaut en Kotlin)
- **kotlin-maven-noarg plugin pour** ajouter automatiquement les constructeurs vide pour les entités JPA

Ajoutez ce plugin `kotlin-maven-plugin` dans le **POM parent** :

```xml
<project>
    <build>
        <plugins>
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
                                    <version>2.1.3.RELEASE</version>
                                </annotationProcessorPath>
                            </annotationProcessorPaths>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

## Déclaration des dépendances

Tous nos modules vont avoir besoin des mêmes dépendances pour fonctionner avec Kotlin :

- `kotlin-stdlib-jdk8` la bibliothèque Kotlin à proprement parler, pour les JDK >= 8
- `kotlin-reflect` la bibliothèque Kotlin de réflection (nécessaire pour pouvoir utiliser Spring 5)
- `jackson-module-kotlin` permet d'ajouter le support de JACKSON sur les classes Kotlin

Déclarez les dépendances partagées dans le **POM parent** :

```xml
<project>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-stdlib-jdk8</artifactId>
                <version>${kotlin.version}</version>
            </dependency>
            <dependency>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-reflect</artifactId>
                <version>${kotlin.version}</version>
            </dependency>
            <dependency>
                <groupId>com.fasterxml.jackson.module</groupId>
                <artifactId>jackson-module-kotlin</artifactId>
                <version>2.9.8</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

Vérifiez que votre configuration compile en redémarrant vos serveurs en faisant s'affronter deux pokemons.
