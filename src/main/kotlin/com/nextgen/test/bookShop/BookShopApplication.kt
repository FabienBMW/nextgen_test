package com.nextgen.test.bookShop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookShopApplication

fun main(args: Array<String>) {
    runApplication<BookShopApplication>(*args)
}
