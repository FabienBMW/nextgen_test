package com.nextgen.test.bookShop.domain.entities

import javax.persistence.*

@Entity
@Table
data class Book(

    @Id
    @Column(name = "BOOK_ID")
    val bookId: String,

    @Column(name = "AUTHOR")
    val author: String,

    @Column(name = "TITLE")
    val title: String,

    @Column(name = "PUBLICATION_DATE")
    val publicationDate: Int,

    @Column(name = "GENDER")
    val gender: String?
) {
}