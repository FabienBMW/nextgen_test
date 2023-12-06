package com.nextgen.test.bookShop.repository

import com.nextgen.test.bookShop.domain.entities.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface BookRepository: JpaRepository<Book, String> {

    fun findAllByAuthorAndTitleAndPublicationDate(author: String, title: String, publicationDate: Int): Optional<Book>

    fun findAllByTitleContainingIgnoreCase(title: String): List<Book>

    fun findAllByGenderContainingIgnoreCase(gender: String): List<Book>

    fun findAllByAuthorContainingIgnoreCase(author: String): List<Book>
}