package org.zenika.arena

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ArenaApplication


fun main(args: Array<String>) {
    runApplication<ArenaApplication>(*args)
}