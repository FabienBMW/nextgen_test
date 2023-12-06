package com.nextgen.test.bookShop.domain.dto

import com.nextgen.test.bookShop.domain.enum.Gender

data class BookDto(

    val author: String = "",
    val title: String = "",
    val publicationDate: Int = 0,
    val gender: Gender? = null
) {
}