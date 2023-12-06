package com.nextgen.test.bookShop.domain.enum

enum class Gender(

    private val value: String
) {

    AUTOBIOGRAPHIE("AUTOBIOGRAPHIE"),
    BIOGRAPHIE("BIOGRAPHIE"),
    CONTE("CONTE"),
    FABLE("FABLE"),
    NOUVELLE("NOUVELLE"),
    ROMAN("ROMAN");

    fun value(): String {
        return value
    }
}