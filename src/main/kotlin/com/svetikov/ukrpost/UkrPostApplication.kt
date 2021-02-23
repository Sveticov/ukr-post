package com.svetikov.ukrpost

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

@SpringBootApplication
@Configuration
class UkrPostApplication

fun main(args: Array<String>) {
    runApplication<UkrPostApplication>(*args)
}

@Component
class InitializeBot{
    init{
        ApiContextInitializer.init()
        TelegramBotsApi().registerBot(UkrPostBot())
    }
}
